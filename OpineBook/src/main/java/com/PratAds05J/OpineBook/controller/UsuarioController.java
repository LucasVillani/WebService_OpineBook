package com.PratAds05J.OpineBook.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.PratAds05J.OpineBook.config.CustomUserDetails;
import com.PratAds05J.OpineBook.dto.UsuarioDTO;
import com.PratAds05J.OpineBook.model.AvaliacaoFilme;
import com.PratAds05J.OpineBook.model.AvaliacaoLivro;
import com.PratAds05J.OpineBook.model.AvaliacaoSerie;
import com.PratAds05J.OpineBook.model.Usuario;
import com.PratAds05J.OpineBook.repository.AvaliacaoFilmeRepository;
import com.PratAds05J.OpineBook.repository.AvaliacaoLivroRepository;
import com.PratAds05J.OpineBook.repository.AvaliacaoSerieRepository;
import com.PratAds05J.OpineBook.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AvaliacaoLivroRepository avaliacaoLivroRepository;
	
	@Autowired
	private AvaliacaoFilmeRepository avaliacaoFilmeRepository;
	
	@Autowired
	private AvaliacaoSerieRepository avaliacaoSerieRepository;
		
	private static final String MENSAGEM = "mensagem";
	
	@ModelAttribute("usuario")
	public Usuario usuarioRegistro() {
		return new Usuario();
	}
	
	@GetMapping("/registro")
	public String formRegistro() {
		return "registro"; 
	}
	
	@RequestMapping("/home")
	public ModelAndView Usuario() {
		ModelAndView mv = new ModelAndView("home");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		
		Usuario usuario = usuarioRepository.findByUsername(username).orElse(null);

		mv.addObject("usuario", usuario);
		return mv;
	}
	
	
	@RequestMapping("/")
	public String formLogin() {
		return "index"; 
	}
	
	@RequestMapping("/confirmacaoRegistro")
	public String formConfirmacaoLogin() {
		return "confirmacaoRegistro"; 
	}
	
	
	@PostMapping("/registro")
	public String criarUsuario(@Valid UsuarioDTO usuarioDTO, BindingResult result, RedirectAttributes attributes) {
		if(usuarioRepository.findByUsername(usuarioDTO.getUsername()).isPresent()) {
			attributes.addFlashAttribute(MENSAGEM, "Username já existente");
			return "redirect:/registro";
		}
		Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCriptografada = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		usuario.setTpConta("U");
		usuarioRepository.save(usuario);
		return "redirect:/confirmacaoRegistro";
	} 
	
	@RequestMapping("/avaliacoes")
	public ModelAndView avaliacoes() {
		ModelAndView mv = new ModelAndView("avaliacoes");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		
		
		Iterable<AvaliacaoLivro> avaliacoesLivro = avaliacaoLivroRepository.findByIdUsuario(username);
		Iterable<AvaliacaoFilme> avaliacoesFilme = avaliacaoFilmeRepository.findByIdUsuario(username);
		Iterable<AvaliacaoSerie> avaliacoesSerie = avaliacaoSerieRepository.findByIdUsuario(username);

		Usuario usuario = usuarioRepository.findByUsername(username).orElse(null);

		mv.addObject("usuario", usuario);
		mv.addObject("avaliacoesLivro", avaliacoesLivro);
		mv.addObject("avaliacoesFilme", avaliacoesFilme);
		mv.addObject("avaliacoesSerie", avaliacoesSerie);
		return mv;
	}
	
	@RequestMapping("/avaliacoesUsuario")
	public ModelAndView avaliacoesUsuario(@RequestParam("idUsuario") String idUsuario) {
		if(!usuarioRepository.findByUsername(idUsuario).isPresent()) {
			return null;
		}
		ModelAndView mv = new ModelAndView("avaliacoesUsuario");
		
		
		List<AvaliacaoLivro> avaliacoesLivro = avaliacaoLivroRepository.findByIdUsuario(idUsuario);
		avaliacoesLivro = avaliacoesLivro.stream()
				.filter(a-> a.getStatus().equals("Aprovado"))
				.collect(Collectors.toList());
		
		List<AvaliacaoFilme> avaliacoesFilme = avaliacaoFilmeRepository.findByIdUsuario(idUsuario);
		avaliacoesFilme = avaliacoesFilme.stream()
				.filter(a-> a.getStatus().equals("Aprovado"))
				.collect(Collectors.toList());
		
		List<AvaliacaoSerie> avaliacoesSerie = avaliacaoSerieRepository.findByIdUsuario(idUsuario);
		avaliacoesSerie = avaliacoesSerie.stream()
				.filter(a-> a.getStatus().equals("Aprovado"))
				.collect(Collectors.toList());
		
		
		Usuario usuario = usuarioRepository.findByUsername(idUsuario).orElse(null);

		mv.addObject("usuario", usuario);
		mv.addObject("avaliacoesLivro", avaliacoesLivro);
		mv.addObject("avaliacoesFilme", avaliacoesFilme);
		mv.addObject("avaliacoesSerie", avaliacoesSerie);
		return mv;
	}
	
	
	@RequestMapping("/aprovacao")
	public ModelAndView aprovacaoAvaliacao() {
		ModelAndView mv = new ModelAndView("aprovacao");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		
		List<AvaliacaoLivro> avaliacoesLivro = avaliacaoLivroRepository.findAll();
		avaliacoesLivro = avaliacoesLivro.stream()
				.filter(a-> a.getStatus().equals("Pendente"))
				.collect(Collectors.toList());
		
		List<AvaliacaoFilme> avaliacoesFilme = avaliacaoFilmeRepository.findAll();
		avaliacoesFilme = avaliacoesFilme.stream()
				.filter(a-> a.getStatus().equals("Pendente"))
				.collect(Collectors.toList());
		
		List<AvaliacaoSerie> avaliacoesSerie = avaliacaoSerieRepository.findAll();
		avaliacoesSerie = avaliacoesSerie.stream()
				.filter(a-> a.getStatus().equals("Pendente"))
				.collect(Collectors.toList());
		
		Usuario usuario = usuarioRepository.findByUsername(username).orElse(null);

		mv.addObject("usuario", usuario);
		mv.addObject("avaliacoesLivro", avaliacoesLivro);
		mv.addObject("avaliacoesFilme", avaliacoesFilme);
		mv.addObject("avaliacoesSerie", avaliacoesSerie);
		return mv;
	}
	
	public boolean isUsuario(String idUsuario) {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		
		return idUsuario.equals(username);
	}
	
	
	
	@PostMapping("/aprovar/{id}/{status}/{admin}")
	public String aprovar(@PathVariable String id, @PathVariable String status, @PathVariable String admin) {
		Long idLong = Long.parseLong(id);
		AvaliacaoFilme avaliacaoFilme = avaliacaoFilmeRepository.findById(idLong).orElse(null);
		AvaliacaoSerie avaliacaoSerie = avaliacaoSerieRepository.findById(idLong).orElse(null);
		AvaliacaoLivro avaliacaoLivro = avaliacaoLivroRepository.findById(idLong).orElse(null);
		
		if(avaliacaoFilme != null) {
			avaliacaoFilme.setStatus(status);
			avaliacaoFilme.setAprovacao(admin);
			avaliacaoFilmeRepository.save(avaliacaoFilme);
		}
		if(avaliacaoSerie != null) {
			avaliacaoSerie.setStatus(status);
			avaliacaoSerie.setAprovacao(admin);
			avaliacaoSerieRepository.save(avaliacaoSerie);

		}
		if(avaliacaoLivro != null) {
			avaliacaoLivro.setStatus(status);
			avaliacaoLivro.setAprovacao(admin);
			avaliacaoLivroRepository.save(avaliacaoLivro);
		}
		
		return "redirect:/aprovacao";

	}
	
}

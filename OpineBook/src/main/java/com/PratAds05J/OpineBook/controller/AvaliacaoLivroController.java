package com.PratAds05J.OpineBook.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.PratAds05J.OpineBook.dto.AvaliacaoLivroDTO;
import com.PratAds05J.OpineBook.model.AvaliacaoLivro;
import com.PratAds05J.OpineBook.repository.AvaliacaoLivroRepository;

@Controller
public class AvaliacaoLivroController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AvaliacaoLivroRepository avaliacaoLivroRepository;
		
	@ModelAttribute("avaliacaoLivro")
	public AvaliacaoLivro avaliacaoLivroRegistro() {
		return new AvaliacaoLivro();
	}
	
	@RequestMapping("/avaliacaoLivro")
	public String formAvaliacaoLivro() {
		return "avaliacaoLivro"; 
	}
	
	@PostMapping("/avaliacaoLivro")
	public String criarAvaliacaoLivro(@Valid AvaliacaoLivroDTO avaliacaoLivroDTO, BindingResult result, RedirectAttributes attributes) {

		AvaliacaoLivro avaliacaoLivro = modelMapper.map(avaliacaoLivroDTO, AvaliacaoLivro.class);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			avaliacaoLivro.setIdUsuario(((UserDetails)principal).getUsername());
		} else {
			avaliacaoLivro.setIdUsuario(principal.toString());
			}
		avaliacaoLivro.setStatus("Pendente");
		avaliacaoLivroRepository.save(avaliacaoLivro);
		return "redirect:/home";
	} 
	
	
}

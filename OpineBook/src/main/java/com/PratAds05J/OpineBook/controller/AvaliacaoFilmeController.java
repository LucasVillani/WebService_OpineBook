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

import com.PratAds05J.OpineBook.dto.AvaliacaoFilmeDTO;
import com.PratAds05J.OpineBook.model.AvaliacaoFilme;
import com.PratAds05J.OpineBook.repository.AvaliacaoFilmeRepository;

@Controller
public class AvaliacaoFilmeController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AvaliacaoFilmeRepository avaliacaoFilmeRepository;
		
	@ModelAttribute("avaliacaoFilme")
	public AvaliacaoFilme avaliacaoFilmeRegistro() {
		return new AvaliacaoFilme();
	}
	
	@RequestMapping("/avaliacaoFilme")
	public String formAvaliacaoFilme() {
		return "avaliacaoFilme"; 
	}
	
	@PostMapping("/avaliacaoFilme")
	public String criarAvaliacaoFilme(@Valid AvaliacaoFilmeDTO avaliacaoFilmeDTO, BindingResult result, RedirectAttributes attributes) {

		AvaliacaoFilme avaliacaoFilme = modelMapper.map(avaliacaoFilmeDTO, AvaliacaoFilme.class);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			avaliacaoFilme.setIdUsuario(((UserDetails)principal).getUsername());
		} else {
			avaliacaoFilme.setIdUsuario(principal.toString());
			}
		avaliacaoFilme.setStatus("Pendente");
		avaliacaoFilmeRepository.save(avaliacaoFilme);
		return "redirect:/home";
	} 
	
	
	
	
}

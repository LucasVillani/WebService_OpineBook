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

import com.PratAds05J.OpineBook.dto.AvaliacaoSerieDTO;
import com.PratAds05J.OpineBook.model.AvaliacaoSerie;
import com.PratAds05J.OpineBook.repository.AvaliacaoSerieRepository;

@Controller
public class AvaliacaoSerieController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AvaliacaoSerieRepository avaliacaoSerieRepository;
		
	@ModelAttribute("avaliacaoSerie")
	public AvaliacaoSerie avaliacaoSerieRegistro() {
		return new AvaliacaoSerie();
	}
	
	@RequestMapping("/avaliacaoSerie")
	public String formAvaliacaoSerie() {
		return "avaliacaoSerie"; 
	}
	
	@PostMapping("/avaliacaoSerie")
	public String criarAvaliacaoSerie(@Valid AvaliacaoSerieDTO avaliacaoSerieDTO, BindingResult result, RedirectAttributes attributes) {

		AvaliacaoSerie avaliacaoSerie = modelMapper.map(avaliacaoSerieDTO, AvaliacaoSerie.class);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			avaliacaoSerie.setIdUsuario(((UserDetails)principal).getUsername());
		} else {
			avaliacaoSerie.setIdUsuario(principal.toString());
		}
		avaliacaoSerie.setStatus("Pendente");
		avaliacaoSerieRepository.save(avaliacaoSerie);
		return "redirect:/home";
	} 
	
	
	
}

package com.PratAds05J.OpineBook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.PratAds05J.OpineBook.model.Usuario;
import com.PratAds05J.OpineBook.repository.UsuarioRepository;
import com.PratAds05J.OpineBook.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
}

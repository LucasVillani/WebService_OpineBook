package com.PratAds05J.OpineBook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.PratAds05J.OpineBook.model.Usuario;
import com.PratAds05J.OpineBook.repository.UsuarioRepository;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow(()
				-> new UsernameNotFoundException("Username não encontrado"));
		
		return new CustomUserDetails(usuario);
	}

}

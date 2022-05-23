package com.PratAds05J.OpineBook.config;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.PratAds05J.OpineBook.model.Usuario;

public class CustomUserDetails implements UserDetails {

	private Usuario usuario;
	
	public CustomUserDetails(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return usuario.getSenha();
	}

	@Override
	public String getUsername() {
		return usuario.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getNomeCompleto() {
		return usuario.getNomeCompleto();
	}
	
	public String getDtNascimento() {
		return usuario.getDtNascimento();
	}
	
	public String getEstado() {
		return usuario.getEstado();
	}
	
	public String getCidade() {
		return usuario.getCidade();
	}

}

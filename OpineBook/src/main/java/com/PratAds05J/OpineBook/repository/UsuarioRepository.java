package com.PratAds05J.OpineBook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PratAds05J.OpineBook.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByUsernameAndSenha(String username, String senha);
	
	Optional<Usuario> findByUsername(String username);
	
}

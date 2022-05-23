package com.PratAds05J.OpineBook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PratAds05J.OpineBook.model.AvaliacaoLivro;


@Repository
public interface AvaliacaoLivroRepository extends JpaRepository<AvaliacaoLivro, Long> {

	List<AvaliacaoLivro> findByIdUsuario(String idUsuario);
	
}

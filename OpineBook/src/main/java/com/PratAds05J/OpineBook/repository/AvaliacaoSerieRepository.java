package com.PratAds05J.OpineBook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PratAds05J.OpineBook.model.AvaliacaoSerie;

@Repository
public interface AvaliacaoSerieRepository extends JpaRepository<AvaliacaoSerie, Long> {

	List<AvaliacaoSerie> findByIdUsuario(String idUsuario);

	
}

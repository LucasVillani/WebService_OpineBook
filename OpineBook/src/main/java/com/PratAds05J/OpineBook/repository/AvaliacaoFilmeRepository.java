package com.PratAds05J.OpineBook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PratAds05J.OpineBook.model.AvaliacaoFilme;

@Repository
public interface AvaliacaoFilmeRepository extends JpaRepository<AvaliacaoFilme, Long>{

	List<AvaliacaoFilme> findByIdUsuario(String idUsuario);

}

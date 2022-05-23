package com.PratAds05J.OpineBook.dto;

public class AvaliacaoSerieDTO {

	private Integer nota;
	
	private String comentario;
	
	private String titulo;

	private String diretor;

	private String elencoPrincipal;
	
	private Integer numTemporadas;

	private String pais;

	private String anoLancamento;

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getElencoPrincipal() {
		return elencoPrincipal;
	}

	public void setElencoPrincipal(String elencoPrincipal) {
		this.elencoPrincipal = elencoPrincipal;
	}

	public Integer getNumTemporadas() {
		return numTemporadas;
	}

	public void setNumTemporadas(Integer numTemporadas) {
		this.numTemporadas = numTemporadas;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
}

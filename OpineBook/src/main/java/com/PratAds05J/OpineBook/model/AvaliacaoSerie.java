package com.PratAds05J.OpineBook.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AvaliacaoSerie implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String idUsuario;
	
	@Column
	private Integer nota;
	
	@Column
	private String comentario;
	
	@OneToMany
	private List<Usuario> usuariosJoinha;
	
	@Column
	private String titulo;

	@Column
	private String diretor;

	@Column
	private String elencoPrincipal;
	
	@Column
	private Integer numTemporadas;

	@Column
	private String pais;

	@Column
	private String anoLancamento;

	@Column
	private String status;
	
	@Column
	private String aprovacao;

	public AvaliacaoSerie() {
		super();
	}

	public AvaliacaoSerie(Long id, String idUsuario, Integer nota, String comentario, List<Usuario> usuariosJoinha,
			String titulo, String diretor, String elencoPrincipal, Integer numTemporadas, String pais,
			String anoLancamento, String status, String aprovacao) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.nota = nota;
		this.comentario = comentario;
		this.usuariosJoinha = usuariosJoinha;
		this.titulo = titulo;
		this.diretor = diretor;
		this.elencoPrincipal = elencoPrincipal;
		this.numTemporadas = numTemporadas;
		this.pais = pais;
		this.anoLancamento = anoLancamento;
		this.status = status;
		this.aprovacao = aprovacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

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

	public List<Usuario> getUsuariosJoinha() {
		return usuariosJoinha;
	}

	public void setUsuariosJoinha(List<Usuario> usuariosJoinha) {
		this.usuariosJoinha = usuariosJoinha;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(String aprovacao) {
		this.aprovacao = aprovacao;
	}


}

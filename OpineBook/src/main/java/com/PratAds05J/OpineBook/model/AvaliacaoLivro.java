package com.PratAds05J.OpineBook.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class AvaliacaoLivro implements Serializable {

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
	private String autor;

	@Column
	private String editora;

	@Column
	private String pais;

	@Column
	private String anoLancamento;

	@Column
	private String status;
	
	@Column
	private String aprovacao;
	
	public AvaliacaoLivro() {
	}

	public AvaliacaoLivro(Long id, String idUsuario,Integer nota,  String comentario,
			List<Usuario> usuariosJoinha,  String titulo,  String autor,  String editora,
			 String pais,  String anoLancamento, String status,
			 String aprovacao) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.nota = nota;
		this.comentario = comentario;
		this.usuariosJoinha = usuariosJoinha;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
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

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	
}

package com.PratAds05J.OpineBook.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, length=20, unique = true)
	private String username;
	
	@NotBlank
	@Column(nullable = false)
	private String senha;
	
	@NotBlank
	@Column(nullable = false)
	private String nomeCompleto;
	
	
	//@Column(nullable = false)
	//@Temporal(TemporalType.DATE)
    //@JsonFormat(pattern="dd-MM-yyyy")
	private String dtNascimento;
	
	@NotBlank
	@Column(nullable = false)
	private String cidade;
	
	@NotBlank
	@Column(nullable = false)
	private String estado;

	@NotBlank
	private String tpConta;
	
	public Usuario() {
	}
	
	public Usuario(Long id, String username, String senha, String nomeCompleto, String dtNascimento, String cidade, String estado,
			String tpConta) {
		super();
		this.id = id;
		this.username = username;
		this.senha = senha;
		this.nomeCompleto = nomeCompleto;
		this.dtNascimento = dtNascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.tpConta = tpConta;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTpConta() {
		return tpConta;
	}
	public void setTpConta(String tpConta) {
		this.tpConta = tpConta;
	}
	
}

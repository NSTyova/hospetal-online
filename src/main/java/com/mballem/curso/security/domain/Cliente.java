package com.mballem.curso.security.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "cliente")
public class Cliente  extends AbstractEntity{

	@Column(name = "nome_cliente", nullable = false, length = 50)
	private String nome;
	@Column(name = "telefone_cliente", nullable = false, length = 15)
	private String telefone;
	@Column(name = "email_cliente", nullable = false, length = 50)
	private String email;
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_nascimento", nullable = false)
	private LocalDate data_nascimento;
	@ManyToOne
	@JoinColumn(name = "id_localizacao")
	private Localizacao localizacao;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public String getNome() {
		return nome;
	}
	public LocalDate getData_nascimento() {
		return data_nascimento;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public Localizacao getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}

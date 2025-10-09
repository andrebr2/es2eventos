package com.es2projeto.es2eventos.auth.dto;

import com.es2projeto.es2eventos.auth.entity.Perfil;

public class ParticipanteRegistrationRequest {

	private String nome;
	private String email;
	private String senha;
	private Perfil perfil = Perfil.PARTICIPANTE;

	public ParticipanteRegistrationRequest() {
	}

	public ParticipanteRegistrationRequest(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfil = Perfil.PARTICIPANTE;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}

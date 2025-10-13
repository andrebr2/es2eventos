package com.es2projeto.es2eventos.auth.dto;

public class RedefinePasswordRequest {

	private String token;
	private String novaSenha;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

}

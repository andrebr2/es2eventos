package com.es2projeto.es2eventos.auth.dto;

import com.es2projeto.es2eventos.auth.entity.Role;

public class UsuarioDTO {

	private String email;
	private String senha;
	private Role role;

	public UsuarioDTO() {

	}

	public UsuarioDTO(String email, String senha, Role role) {
		this.email = email;
		this.senha = senha;
		this.role = role;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
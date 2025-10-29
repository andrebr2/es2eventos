package com.es2projeto.es2eventos.participante.dto;

import com.es2projeto.es2eventos.participante.entities.Participante;
import com.es2projeto.es2eventos.tipo.dto.TipoParticipanteDTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class ParticipanteDTO {

	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private TipoParticipanteDTO tipoParticipante;
	private String numero;
	private String complemento;
	private String cep;

	public ParticipanteDTO() {
	}

	public ParticipanteDTO(Long id, String nome, String sobrenome, String email, String telefone,TipoParticipanteDTO tipoParticipante, String numero,
			String complemento, String cep) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.tipoParticipante = tipoParticipante;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	public ParticipanteDTO(Participante entity) {
		id = entity.getId();
		nome = entity.getNome();
		sobrenome = entity.getSobrenome();
		email = entity.getEmail();
		telefone = entity.getTelefone();
		tipoParticipante = new TipoParticipanteDTO(entity.getTipoParticipante());
		numero = entity.getNumero();
		complemento = entity.getComplemento();
		cep = entity.getEndereco() != null ? entity.getEndereco().getCep() : null;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public TipoParticipanteDTO getTipoParticipante() {
		return tipoParticipante;
	}

	public void setTipoParticipante(TipoParticipanteDTO tipoParticipante) {
		this.tipoParticipante = tipoParticipante;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
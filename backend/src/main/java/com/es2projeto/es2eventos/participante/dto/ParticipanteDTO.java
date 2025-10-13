package com.es2projeto.es2eventos.participante.dto;

import java.io.Serializable;

public class ParticipanteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String sobrenome;
	private Long tipoParticipanteId;
	private String numero;
	private String complemento;
	private String cep; // Para buscar ou criar o Endereco

	public ParticipanteDTO() {
	}

	public ParticipanteDTO(String nome, String sobrenome, Long tipoParticipanteId, String numero, String complemento,
			String cep) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipoParticipanteId = tipoParticipanteId;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}
	/*
	public ParticipanteDTO(Participante entity) {
		nome = entity.getNome();
		sobrenome = entity.getSobrenome();
		tipoParticipante = new TipoParticipanteDTO(entity.getTipoParticipante());
		numero = entity.getNumero();
		complemento = entity.getComplemento();
		cep = cep; - endereco = new EnderecoDTO(entity.getEndeeco());
	}*/

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

	public Long getTipoParticipanteId() {
		return tipoParticipanteId;
	}

	public void setTipoParticipanteId(Long tipoParticipanteId) {
		this.tipoParticipanteId = tipoParticipanteId;
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
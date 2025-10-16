package com.es2projeto.es2eventos.participante.dto;

import com.es2projeto.es2eventos.participante.entities.Participante;
import com.es2projeto.es2eventos.tipo.dto.TipoParticipanteDTO;

public class ParticipanteDTO {

	private Long id;
	private String nome;
	private String sobrenome;
	private TipoParticipanteDTO tipoParticipante;
	private String numero;
	private String complemento;
	private String cep;

	public ParticipanteDTO() {
	}

	public ParticipanteDTO(Long id, String nome, String sobrenome, TipoParticipanteDTO tipoParticipante, String numero,
			String complemento, String cep) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipoParticipante = tipoParticipante;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	public ParticipanteDTO(Participante entity) {
		id = entity.getId();
		nome = entity.getNome();
		sobrenome = entity.getSobrenome();
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
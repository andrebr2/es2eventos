package com.es2projeto.es2eventos.participante.dto;

public class ParticipanteDTO {

	private Long id;
	private String nome;
	private String sobrenome;
	private Long tipoParticipanteId;
	private String numero;
	private String complemento;
	private String cep;

	public ParticipanteDTO() {
	}

	public ParticipanteDTO(Long id, String nome, String sobrenome, Long tipoParticipanteId, String numero,
			String complemento, String cep) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipoParticipanteId = tipoParticipanteId;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
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
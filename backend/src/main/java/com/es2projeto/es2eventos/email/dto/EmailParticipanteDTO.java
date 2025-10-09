package com.es2projeto.es2eventos.email.dto;

public class EmailParticipanteDTO {
	private Long id;
	private String enderecoEmail;
	private Long participanteId;

	public EmailParticipanteDTO() {
	}

	public EmailParticipanteDTO(Long id, String enderecoEmail, Long participanteId) {
		this.id = id;
		this.enderecoEmail = enderecoEmail;
		this.participanteId = participanteId;
	}

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnderecoEmail() {
		return enderecoEmail;
	}

	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}

	public Long getParticipanteId() {
		return participanteId;
	}

	public void setParticipanteId(Long participanteId) {
		this.participanteId = participanteId;
	}
}

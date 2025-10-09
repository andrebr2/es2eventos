package com.es2projeto.es2eventos.email.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_emails_participantes")
public class EmailParticipante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String enderecoEmail;

	private Long participanteId;

	public EmailParticipante() {
	}

	public EmailParticipante(String enderecoEmail, Long participanteId) {
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

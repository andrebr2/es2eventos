package com.es2projeto.es2eventos.telefone.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TelefoneParticipanteDTO {

	private Long id;

	@NotBlank(message = "Número de telefone é obrigatório")
	private String nroTelefone;

	@Min(value = 10, message = "O código de área deve ter pelo menos 2 dígitos")
	private int codigoArea;

	@NotNull(message = "ParticipanteId é obrigatório")
	private Long participanteId;

	public TelefoneParticipanteDTO() {
	}

	public TelefoneParticipanteDTO(Long id, String nroTelefone, int codigoArea, Long participanteId) {
		this.id = id;
		this.nroTelefone = nroTelefone;
		this.codigoArea = codigoArea;
		this.participanteId = participanteId;
	}

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNroTelefone() {
		return nroTelefone;
	}

	public void setNroTelefone(String nroTelefone) {
		this.nroTelefone = nroTelefone;
	}

	public int getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}

	public Long getParticipanteId() {
		return participanteId;
	}

	public void setParticipanteId(Long participanteId) {
		this.participanteId = participanteId;
	}
}
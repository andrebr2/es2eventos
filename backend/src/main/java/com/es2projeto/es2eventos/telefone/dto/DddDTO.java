package com.es2projeto.es2eventos.telefone.dto;

import jakarta.validation.constraints.Min;

public class DddDTO {

	@Min(value = 10, message = "O código de área deve ter pelo menos 2 dígitos")
	private int codigoArea;

	public DddDTO() {
	}

	public DddDTO(int codigoArea) {
		this.codigoArea = codigoArea;
	}

	public int getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}
}

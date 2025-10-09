package com.es2projeto.es2eventos.telefone.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ddd")
public class DDD {

	@Id
	private int codigoArea;

	public DDD() {
	}

	public DDD(int codigoArea) {
		this.codigoArea = codigoArea;
	}

	public int getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}
}

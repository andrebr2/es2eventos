package com.es2projeto.es2eventos.palestra.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_palestra")
public class Palestra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomePalestra;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dataHora;

	private String palestrante;
	private Integer limiteVagas;
	private String local;

	public Palestra() {

	}

	public Palestra(Long id, String nomePalestra, LocalDateTime dataHora, String palestrante, Integer limiteVagas,
			String local) {
		this.id = id;
		this.nomePalestra = nomePalestra;
		this.dataHora = dataHora;
		this.palestrante = palestrante;
		this.limiteVagas = limiteVagas;
		this.local = local;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePalestra() {
		return nomePalestra;
	}

	public void setNomePalestra(String nomePalestra) {
		this.nomePalestra = nomePalestra;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(String palestrante) {
		this.palestrante = palestrante;
	}

	public Integer getLimiteVagas() {
		return limiteVagas;
	}

	public void setLimiteVagas(Integer limiteVagas) {
		this.limiteVagas = limiteVagas;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palestra other = (Palestra) obj;
		return Objects.equals(id, other.id);
	}

}
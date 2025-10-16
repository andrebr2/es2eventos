package com.es2projeto.es2eventos.inscricao.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.es2projeto.es2eventos.palestra.entities.Palestra;
import com.es2projeto.es2eventos.participante.entities.Participante;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_inscricao")
public class Inscricao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "palestra_id", nullable = false)
	private Palestra palestra;

	@ManyToOne
	@JoinColumn(name = "participante_id", nullable = false)
	private Participante participante;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dataHoraInscricao;

	public Inscricao() {

	}

	public Inscricao(Long id, Palestra palestra, Participante participante, LocalDateTime dataHoraInscricao) {
		this.id = id;
		this.palestra = palestra;
		this.participante = participante;
		this.dataHoraInscricao = dataHoraInscricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Palestra getPalestra() {
		return palestra;
	}

	public void setPalestra(Palestra palestra) {
		this.palestra = palestra;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public LocalDateTime getDataHoraIncricao() {
		return dataHoraInscricao;
	}

	public void setDataHoraIncricao(LocalDateTime dataHoraInscricao) {
		this.dataHoraInscricao = dataHoraInscricao;
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
		Inscricao other = (Inscricao) obj;
		return Objects.equals(id, other.id);
	}

}
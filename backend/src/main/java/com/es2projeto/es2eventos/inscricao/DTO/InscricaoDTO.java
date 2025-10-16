package com.es2projeto.es2eventos.inscricao.DTO;

import java.time.LocalDateTime;

import com.es2projeto.es2eventos.inscricao.entities.Inscricao;
import com.es2projeto.es2eventos.palestra.dto.PalestraDTO;
import com.es2projeto.es2eventos.participante.dto.ParticipanteDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

public class InscricaoDTO {

	private Long id;
	private PalestraDTO palestra;
	private ParticipanteDTO participante;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dataHoraInscricao;

	public InscricaoDTO() {
		
	}

	public InscricaoDTO(Long id, PalestraDTO palestra, ParticipanteDTO participante, LocalDateTime dataHoraInscricao) {
		this.id = id;
		this.palestra = palestra;
		this.participante = participante;
		this.dataHoraInscricao = dataHoraInscricao;
	}
	
	public InscricaoDTO(Inscricao entity) {
		id = entity.getId();
		palestra = new PalestraDTO(entity.getPalestra());
		participante = new ParticipanteDTO(entity.getParticipante());
		dataHoraInscricao = entity.getDataHoraIncricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PalestraDTO getPalestra() {
		return palestra;
	}

	public void setPalestra(PalestraDTO palestra) {
		this.palestra = palestra;
	}

	public ParticipanteDTO getParticipante() {
		return participante;
	}

	public void setParticipante(ParticipanteDTO participante) {
		this.participante = participante;
	}

	public LocalDateTime getDataHoraInscricao() {
		return dataHoraInscricao;
	}

	public void setDataHoraInscricao(LocalDateTime dataHoraInscricao) {
		this.dataHoraInscricao = dataHoraInscricao;
	}
	
	
}
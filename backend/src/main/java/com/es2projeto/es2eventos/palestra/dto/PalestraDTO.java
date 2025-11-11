package com.es2projeto.es2eventos.palestra.dto;

import java.time.LocalDateTime;

import com.es2projeto.es2eventos.evento.dto.EventoDTO;
import com.es2projeto.es2eventos.palestra.entities.Palestra;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PalestraDTO {

	private Long id;
	private String nomePalestra;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dataHora;

	private String palestrante;
	private Integer limiteVagas;
	private String local;
	private EventoDTO evento;


	public PalestraDTO() {

	}

	public PalestraDTO(Long id, String nomePalestra, LocalDateTime dataHora, String palestrante, Integer limiteVagas,
			String local, EventoDTO evento) {
		this.id = id;
		this.nomePalestra = nomePalestra;
		this.dataHora = dataHora;
		this.palestrante = palestrante;
		this.limiteVagas = limiteVagas;
		this.local = local;
		this.evento = evento;
	}
	
	public PalestraDTO(Palestra entity) {
		id = entity.getId();
		nomePalestra = entity.getNomePalestra();
		dataHora = entity.getDataHora();
		palestrante = entity.getPalestrante();
		limiteVagas = entity.getLimiteVagas();
		local = entity.getLocal();
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

	public EventoDTO getEvento() {
		return evento;
	}

	public void setEvento(EventoDTO evento) {
		this.evento = evento;
	}

}
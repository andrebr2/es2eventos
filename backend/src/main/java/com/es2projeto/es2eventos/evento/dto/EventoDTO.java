package com.es2projeto.es2eventos.evento.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.es2projeto.es2eventos.evento.entities.Evento;
import com.es2projeto.es2eventos.palestra.dto.PalestraDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EventoDTO {

	private Long id;
	private String nomeEvento;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataInicio;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataTermino;
	private String local;
	private String descricao;
	private String site;
	
	private List<PalestraDTO> palestras;

	public EventoDTO() {

	}

	public EventoDTO(Long id, String nomeEvento, LocalDate dataInicio, LocalDate dataTermino, String local,
			String descricao, String site) {
		this.id = id;
		this.nomeEvento = nomeEvento;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.local = local;
		this.descricao = descricao;
		this.site = site;
	}

	public EventoDTO(Evento entity) {
		id = entity.getId();
		nomeEvento = entity.getNomeEvento();
		dataInicio = entity.getDataInicio();
		dataTermino = entity.getDataTermino();
		local = entity.getLocal();
		descricao = entity.getDescricao();
		site = entity.getSite();
		palestras = entity.getPalestras()
                .stream()
                .map(PalestraDTO::new)
                .collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public List<PalestraDTO> getPalestras() {
		return palestras;
	}

	public void setPalestras(List<PalestraDTO> palestras) {
		this.palestras = palestras;
	}

}
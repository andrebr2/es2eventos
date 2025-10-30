package com.es2projeto.es2eventos.participante.dto;

import com.es2projeto.es2eventos.participante.entities.Participante;

public class ParticipanteRefDTO {

	private Long id;
	private String nome;

	public ParticipanteRefDTO() {

	}

	public ParticipanteRefDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public ParticipanteRefDTO(Participante entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
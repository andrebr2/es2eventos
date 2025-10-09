package com.es2projeto.es2eventos.tipo.dto;

import com.es2projeto.es2eventos.tipo.entities.TipoParticipante;

public class TipoParticipanteDTO {

    private Long id;
    private String descricao;

    public TipoParticipanteDTO() {
    }

    public TipoParticipanteDTO(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public TipoParticipanteDTO(TipoParticipante entity) {
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
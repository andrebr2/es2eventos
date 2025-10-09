package com.es2projeto.es2eventos.telefone.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_telefones_participante")
public class TelefoneParticipante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nroTelefone;

    private int codigoArea;

    private Long participanteId;

    public TelefoneParticipante() {}

    public TelefoneParticipante(Long id, String nroTelefone, int codigoArea, Long participanteId) {
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
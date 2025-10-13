package com.es2projeto.es2eventos.telefone.entities;

import java.io.Serializable;

import com.es2projeto.es2eventos.participante.entities.Participante;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_telefones_participante")
public class TelefoneParticipante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nroTelefone;

    private int codigoArea;

    @ManyToOne(cascade = CascadeType.ALL) // Persistirá se o participante for novo
    @JoinColumn(name = "participante_id")
    private Participante participante;

    public TelefoneParticipante() {
    }

    public TelefoneParticipante(Long id, String nroTelefone, int codigoArea, Participante participante) {
    	this.id = id;
        this.nroTelefone = nroTelefone;
        this.codigoArea = codigoArea;
        this.participante = participante;
    }

    // ===== Getters e Setters =====
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

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
}
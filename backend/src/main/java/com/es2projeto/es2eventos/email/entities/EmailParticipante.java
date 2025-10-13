package com.es2projeto.es2eventos.email.entities;

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
@Table(name = "tb_emails_participantes")
public class EmailParticipante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enderecoEmail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participante_id")
    private Participante participante;

    public EmailParticipante() {
    }

    public EmailParticipante(String enderecoEmail, Participante participante) {
        this.enderecoEmail = enderecoEmail;
        this.participante = participante;
    }

    // ===== Getters e Setters =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
}
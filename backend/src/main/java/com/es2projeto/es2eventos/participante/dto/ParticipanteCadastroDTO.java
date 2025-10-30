package com.es2projeto.es2eventos.participante.dto;

import com.es2projeto.es2eventos.auth.entity.Role;
import com.es2projeto.es2eventos.endereco.dto.EnderecoDTO;
import com.es2projeto.es2eventos.tipo.dto.TipoParticipanteDTO;

public class ParticipanteCadastroDTO {

    private String email;
    private String senha;
    private Role role;

    private String nome;
    private String sobrenome;
    private String telefone;
    private TipoParticipanteDTO tipoParticipante;
    private String numero;
    private String complemento;
    private EnderecoDTO endereco;

    public ParticipanteCadastroDTO() {
        this.role = Role.PARTICIPANTE;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoParticipanteDTO getTipoParticipante() {
        return tipoParticipante;
    }

    public void setTipoParticipante(TipoParticipanteDTO tipoParticipante) {
        this.tipoParticipante = tipoParticipante;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
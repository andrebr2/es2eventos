package com.es2projeto.es2eventos.participante.dto;

import com.es2projeto.es2eventos.endereco.dto.EnderecoDTO;
import com.es2projeto.es2eventos.participante.entities.Participante;
import com.es2projeto.es2eventos.tipo.dto.TipoParticipanteDTO;

public class ParticipanteDTO {

	private Long id;
	private String email;
	private String nome;
	private String sobrenome;
	private String telefone;
	private String numero;
	private String complemento;
	private EnderecoDTO endereco;
	private TipoParticipanteDTO tipoParticipante;

	public ParticipanteDTO() {

	}

	public ParticipanteDTO(Participante entity) {
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.nome = entity.getNome();
		this.sobrenome = entity.getSobrenome();
		this.telefone = entity.getTelefone();
		this.numero = entity.getNumero();
		this.complemento = entity.getComplemento();

		if (entity.getEndereco() != null) {
			this.endereco = new EnderecoDTO(entity.getEndereco());
		}

		if (entity.getTipoParticipante() != null) {
			this.tipoParticipante = new TipoParticipanteDTO(entity.getTipoParticipante());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public TipoParticipanteDTO getTipoParticipante() {
		return tipoParticipante;
	}

	public void setTipoParticipante(TipoParticipanteDTO tipoParticipante) {
		this.tipoParticipante = tipoParticipante;
	}

}
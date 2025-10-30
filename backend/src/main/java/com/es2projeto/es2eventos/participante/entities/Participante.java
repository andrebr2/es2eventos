package com.es2projeto.es2eventos.participante.entities;

import com.es2projeto.es2eventos.auth.entity.Usuario;
import com.es2projeto.es2eventos.endereco.entities.Endereco;
import com.es2projeto.es2eventos.tipo.entities.TipoParticipante;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "tb_participante")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Participante extends Usuario {

	private String nome;
	private String sobrenome;

	// Formato (XX)XXXXX-XXXX ou (XX)XXXX-XXXX
	@Pattern(regexp = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}$", message = "Telefone deve estar no formato (XX)XXXXX-XXXX")
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "tipo_participante_id")
	private TipoParticipante tipoParticipante;

	private String numero;
	private String complemento;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	public Participante() {
		
	}

	public Participante(String nome, String sobrenome, String telefone, TipoParticipante tipoParticipante,
			String numero, String complemento, Endereco endereco) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.tipoParticipante = tipoParticipante;
		this.numero = numero;
		this.complemento = complemento;
		this.endereco = endereco;
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

	public TipoParticipante getTipoParticipante() {
		return tipoParticipante;
	}

	public void setTipoParticipante(TipoParticipante tipoParticipante) {
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
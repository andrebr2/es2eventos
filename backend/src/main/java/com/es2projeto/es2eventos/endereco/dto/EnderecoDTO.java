package com.es2projeto.es2eventos.endereco.dto;

import com.es2projeto.es2eventos.endereco.entities.Endereco;

public class EnderecoDTO {

	 private Long id;
   private String cep;
   private String logradouro;
   private String bairro;
   private String localidade;
   private String uf;

   public EnderecoDTO() {}

   public EnderecoDTO(Long id, String cep, String logradouro, String bairro, String localidade, String uf) {
   	this.id = id;
   	this.cep = cep;
       this.logradouro = logradouro;
       this.bairro = bairro;
       this.localidade = localidade;
       this.uf = uf;
   }

   public EnderecoDTO(Endereco entity) {
   	id = entity.getId();
       cep = entity.getCep();
       logradouro = entity.getLogradouro();
       bairro = entity.getBairro();
       localidade = entity.getLocalidade();
       uf = entity.getUf();
   }
   
   // Getters e Setters
   public Long getId() { 
       return id; 
   }
   public void setId(Long id) { 
       this.id = id; 
   }
   public String getCep() { 
   	return cep; 
   }
   public void setCep(String cep) { 
   	this.cep = cep; 
   }

   public String getLogradouro() { 
   	return logradouro; 
   }
   public void setLogradouro(String logradouro) { 
   	this.logradouro = logradouro; 
   }

   public String getBairro() {
   	return bairro; 
   }
   public void setBairro(String bairro) { 
   	this.bairro = bairro; 
   }

   public String getLocalidade() { 
   	return localidade; 
   }
   public void setLocalidade(String localidade) { 
   	this.localidade = localidade; 
   }

   public String getUf() { 
   	return uf; 
   }
   public void setUf(String uf) { 
   	this.uf = uf; 
   }
   
}
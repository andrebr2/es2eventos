package com.es2projeto.es2eventos.endereco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.es2projeto.es2eventos.endereco.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
}

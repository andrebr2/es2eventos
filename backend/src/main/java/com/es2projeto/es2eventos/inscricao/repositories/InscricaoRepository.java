package com.es2projeto.es2eventos.inscricao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.es2projeto.es2eventos.inscricao.entities.Inscricao;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

}
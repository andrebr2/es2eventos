package com.es2projeto.es2eventos.tipo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.es2projeto.es2eventos.tipo.entities.TipoParticipante;

@Repository
public interface TipoParticipanteRepository extends JpaRepository<TipoParticipante, Long> {

}
package com.es2projeto.es2eventos.participante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.es2projeto.es2eventos.participante.entities.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

}
package com.es2projeto.es2eventos.telefone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.es2projeto.es2eventos.telefone.entities.TelefoneParticipante;

@Repository
public interface TelefoneParticipanteRepository extends JpaRepository<TelefoneParticipante, Long> {

}

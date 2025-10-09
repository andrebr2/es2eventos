package com.es2projeto.es2eventos.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.es2projeto.es2eventos.email.entities.EmailParticipante;

public interface EmailParticipanteRepository extends JpaRepository<EmailParticipante, Long> {
	
}

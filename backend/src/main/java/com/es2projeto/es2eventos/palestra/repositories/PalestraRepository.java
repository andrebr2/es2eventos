package com.es2projeto.es2eventos.palestra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.es2projeto.es2eventos.palestra.entities.Palestra;

public interface PalestraRepository extends JpaRepository<Palestra, Long> {

	List<Palestra> findByPalestrante(String palestrante);
	
}
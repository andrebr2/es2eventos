package com.es2projeto.es2eventos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organizador")
public class OrganizadorController {

	// Painel do organizador
	@GetMapping("/dashboard")
	public ResponseEntity<String> dashboard() {
		return ResponseEntity.ok("Painel do organizador");
	}

	// listar eventos do organizador
	@GetMapping("/eventos")
	public ResponseEntity<String> listarEventos() {
		return ResponseEntity.ok("Lista de eventos");
	}
}
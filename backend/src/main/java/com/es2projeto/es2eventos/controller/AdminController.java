package com.es2projeto.es2eventos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2projeto.es2eventos.auth.entity.Usuario;
import com.es2projeto.es2eventos.auth.repository.UsuarioRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private final UsuarioRepository usuarioRepository;

	public AdminController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	// Listar todos os usuários
	@GetMapping("/users")
	public ResponseEntity<List<Usuario>> listUsers() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

	// Deletar usuário por ID
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		if (usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
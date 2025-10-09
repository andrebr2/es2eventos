package com.es2projeto.es2eventos.auth.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2projeto.es2eventos.auth.entity.Usuario;
import com.es2projeto.es2eventos.auth.repository.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;

	public AuthController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/register")
	public String registrar(@RequestBody Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
		return "Usuário registrado com sucesso!";
	}

	@GetMapping("/login")
	public String login() {
		return "Tela de login (ou endpoint autenticado)";
	}
}
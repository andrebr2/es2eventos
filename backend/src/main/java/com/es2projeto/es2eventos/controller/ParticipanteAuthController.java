package com.es2projeto.es2eventos.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2projeto.es2eventos.auth.dto.ParticipanteRegistrationRequest;
import com.es2projeto.es2eventos.auth.entity.Perfil;
import com.es2projeto.es2eventos.auth.entity.Usuario;
import com.es2projeto.es2eventos.auth.repository.UsuarioRepository;

@RestController("participanteAuthController")
@RequestMapping("/participante/auth")
public class ParticipanteAuthController {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;

	public ParticipanteAuthController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}

	// Endpoint para registrar participante
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody ParticipanteRegistrationRequest req) {
		Usuario usuario = new Usuario();
		usuario.setNome(req.getNome());
		usuario.setEmail(req.getEmail());
		usuario.setSenha(passwordEncoder.encode(req.getSenha()));
		usuario.setPerfil(Perfil.PARTICIPANTE);

		usuarioRepository.save(usuario);

		return ResponseEntity.created(URI.create("/participante/auth/" + usuario.getId()))
				.body("Participante registrado com sucesso!");
	}

	// Endpoint para pegar informações do participante logado
	@GetMapping("/me")
	public ResponseEntity<Usuario> me(@AuthenticationPrincipal Usuario usuario) {
		if (usuario == null)
			return ResponseEntity.status(401).build();
		return ResponseEntity.ok(usuario);
	}
}
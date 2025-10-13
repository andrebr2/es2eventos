package com.es2projeto.es2eventos.auth.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2projeto.es2eventos.auth.dto.LoginRequest;
import com.es2projeto.es2eventos.auth.dto.RedefinePasswordRequest;
import com.es2projeto.es2eventos.auth.dto.ResetPasswordRequest;
import com.es2projeto.es2eventos.auth.entity.Usuario;
import com.es2projeto.es2eventos.auth.repository.UsuarioRepository;
import com.es2projeto.es2eventos.auth.service.TokenBlacklist;
import com.es2projeto.es2eventos.config.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final JwtUtil jwtUtil;
	private final TokenBlacklist tokenBlacklist;
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;

	private final Map<String, String> resetTokens = new HashMap<>();

	public AuthController(JwtUtil jwtUtil, TokenBlacklist tokenBlacklist, UsuarioRepository usuarioRepository,
			PasswordEncoder passwordEncoder) {
		this.jwtUtil = jwtUtil;
		this.tokenBlacklist = tokenBlacklist;
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Usuario usuario) {
		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
			return ResponseEntity.status(400).body("Email já cadastrado");
		}

		// Criptografa a senha antes de salvar
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuario);

		return ResponseEntity.ok("Usuário registrado com sucesso");
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(request.getEmail());

		if (usuarioOpt.isPresent() && passwordEncoder.matches(request.getSenha(), usuarioOpt.get().getSenha())) {
			Usuario usuario = usuarioOpt.get();
			String token = jwtUtil.generateToken(usuario.getEmail());

			Map<String, Object> response = new HashMap<>();
			response.put("id", usuario.getId());
			response.put("nome", usuario.getNome());
			response.put("email", usuario.getEmail());
			response.put("token", token);

			return ResponseEntity.ok(response);
		}

		return ResponseEntity.status(401).body("Credenciais inválidas");
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logout(@RequestHeader("Authorization") String authHeader) {
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			String token = authHeader.substring(7);
			tokenBlacklist.add(token);
			return ResponseEntity.ok("Logout realizado com sucesso.");
		}
		return ResponseEntity.badRequest().body("Token inválido ou ausente.");
	}

	@PostMapping("/reset")
	public ResponseEntity<?> solicitarReset(@RequestBody ResetPasswordRequest request) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(request.getEmail());

		if (usuarioOpt.isEmpty()) {
			return ResponseEntity.status(404).body("Usuário não encontrado");
		}

		String tokenReset = jwtUtil.generateToken(request.getEmail());
		resetTokens.put(request.getEmail(), tokenReset);

		return ResponseEntity.ok("Token de redefinição gerado: " + tokenReset);
	}

	@PostMapping("/redefinir")
	public ResponseEntity<?> redefinirSenha(@RequestBody RedefinePasswordRequest request) {
		String email = jwtUtil.extractEmail(request.getToken());

		if (!jwtUtil.validateToken(request.getToken())) {
			return ResponseEntity.status(400).body("Token inválido ou expirado");
		}

		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
		if (usuarioOpt.isEmpty()) {
			return ResponseEntity.status(404).body("Usuário não encontrado");
		}

		Usuario usuario = usuarioOpt.get();
		usuario.setSenha(request.getNovaSenha());
		usuarioRepository.save(usuario);

		return ResponseEntity.ok("Senha redefinida com sucesso");
	}
}
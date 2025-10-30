package com.es2projeto.es2eventos.auth.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2projeto.es2eventos.auth.dto.LoginRequest;
import com.es2projeto.es2eventos.auth.dto.RedefinePasswordRequest;
import com.es2projeto.es2eventos.auth.dto.ResetPasswordRequest;
import com.es2projeto.es2eventos.auth.entity.Usuario;
import com.es2projeto.es2eventos.auth.service.UsuarioService;
import com.es2projeto.es2eventos.config.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UsuarioService usuarioService;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	public AuthController(UsuarioService usuarioService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		this.usuarioService = usuarioService;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		Optional<Usuario> usuarioOpt = usuarioService.findByEmail(request.getEmail());

		if (usuarioOpt.isPresent() && passwordEncoder.matches(request.getSenha(), usuarioOpt.get().getSenha())) {
			Usuario usuario = usuarioOpt.get();
			String token = jwtUtil.generateToken(usuario.getEmail());

			Map<String, Object> response = new HashMap<>();
			response.put("id", usuario.getId());
			response.put("email", usuario.getEmail());
			response.put("role", usuario.getRole());
			response.put("token", token);

			return ResponseEntity.ok(response);
		}

		return ResponseEntity.status(401).body("Credenciais inválidas");
	}

	@PostMapping("/reset")
	public ResponseEntity<?> solicitarReset(@RequestBody ResetPasswordRequest request) {
		usuarioService.sendPasswordResetToken(request.getEmail());
		return ResponseEntity.ok("Token de redefinição gerado (ver console por enquanto).");
	}

	@PostMapping("/redefinir")
	public ResponseEntity<?> redefinirSenha(@RequestBody RedefinePasswordRequest request) {
		boolean sucesso = usuarioService.redefineSenha(request.getToken(), request.getNovaSenha());
		if (sucesso)
			return ResponseEntity.ok("Senha redefinida com sucesso");
		return ResponseEntity.status(400).body("Token inválido ou expirado");
	}
}
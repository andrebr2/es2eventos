package com.es2projeto.es2eventos.auth.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.es2projeto.es2eventos.auth.entity.Usuario;
import com.es2projeto.es2eventos.auth.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;

	private final Map<String, ResetToken> resetTokens = new HashMap<>();

	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	 public Optional<Usuario> findByUsername(String username) {
	        return usuarioRepository.findByUsername(username);
	    }

	public void sendPasswordResetToken(String email) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
		if (usuarioOpt.isEmpty())
			return;

		String token = UUID.randomUUID().toString();
		LocalDateTime expiracao = LocalDateTime.now().plusMinutes(30);
		resetTokens.put(token, new ResetToken(usuarioOpt.get().getId(), expiracao));

		System.out.println("Token de reset para " + email + ": " + token);
	}

	public boolean redefineSenha(String token, String novaSenha) {
		ResetToken reset = resetTokens.get(token);
		if (reset == null || reset.getExpiracao().isBefore(LocalDateTime.now()))
			return false;

		Optional<Usuario> usuarioOpt = usuarioRepository.findById(reset.getUsuarioId());
		if (usuarioOpt.isEmpty())
			return false;

		Usuario usuario = usuarioOpt.get();
		usuario.setSenha(passwordEncoder.encode(novaSenha));
		usuarioRepository.save(usuario);
		resetTokens.remove(token);
		return true;
	}

	private static class ResetToken {
		private final Long usuarioId;
		private final LocalDateTime expiracao;

		public ResetToken(Long usuarioId, LocalDateTime expiracao) {
			this.usuarioId = usuarioId;
			this.expiracao = expiracao;
		}

		public Long getUsuarioId() {
			return usuarioId;
		}

		public LocalDateTime getExpiracao() {
			return expiracao;
		}
	}
}
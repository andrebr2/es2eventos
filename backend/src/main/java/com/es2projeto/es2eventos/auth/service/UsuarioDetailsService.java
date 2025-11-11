package com.es2projeto.es2eventos.auth.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.es2projeto.es2eventos.auth.entity.Usuario;
import com.es2projeto.es2eventos.auth.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(username);

        if (usuarioOpt.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }

        Usuario usuario = usuarioOpt.get();

        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getUsername())
                .password(usuario.getSenha())
                .authorities("USER")
                .build();
    }
}
package com.es2projeto.es2eventos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	// Bean para criptografia de senhas
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Configuração de segurança
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				// Desabilita CSRF e frame options para H2 console
				.csrf(csrf -> csrf.disable())
				.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
				// Configuração de rotas e roles
				.authorizeHttpRequests(auth -> auth.requestMatchers("/h2-console/**").permitAll()
						.requestMatchers("/participante/auth/**").permitAll().requestMatchers("/admin/**")
						.hasRole("ADMIN").requestMatchers("/organizador/**").hasRole("ORGANIZADOR")
						.requestMatchers("/participantes/**").hasRole("PARTICIPANTE").anyRequest().authenticated())
				// Login e logout
				.formLogin(form -> form.permitAll()).logout(logout -> logout.permitAll());

		return http.build();
	}
}
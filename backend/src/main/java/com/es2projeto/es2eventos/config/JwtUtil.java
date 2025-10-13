package com.es2projeto.es2eventos.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.es2projeto.es2eventos.auth.service.TokenBlacklist;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret; // definida no application.properties

	@Value("${jwt.expiration}")
	private long expiration; // em milissegundos

	private final TokenBlacklist blacklist;

	public JwtUtil(TokenBlacklist blacklist) {
		this.blacklist = blacklist;
	}

	public String generateToken(String email) {
		Date now = new Date();
		Date expiry = new Date(now.getTime() + expiration);

		return Jwts.builder().setSubject(email).setIssuedAt(now).setExpiration(expiry)
				.signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256).compact();
	}

	public boolean validateToken(String token) {
		try {
			if (blacklist.isBlacklisted(token)) {
				return false; // token bloqueado (logout)
			}

			Claims claims = getClaims(token);
			return !claims.getExpiration().before(new Date());
		} catch (Exception e) {
			return false;
		}
	}

	public String extractEmail(String token) {
		return getClaims(token).getSubject();
	}

	private Claims getClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parseClaimsJws(token)
				.getBody();
	}
}
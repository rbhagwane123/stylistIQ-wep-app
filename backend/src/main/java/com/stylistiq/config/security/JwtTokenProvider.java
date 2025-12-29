package com.stylistiq.config.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtTokenProvider {

	SecretKey key = Keys.hmacShaKeyFor(JwtConstants.SECRET_KEY.getBytes());

	public String generateToken(Authentication auth) {
		String jwt = Jwts.builder().setIssuedAt(new Date(new Date().getTime() + 846000000))
				.claim("username", auth.getName()).signWith(key).compact();

		return jwt;

	}

	public String getUsernameFromToken(String jwt) {
		jwt = jwt.substring(7);
		Claims claims =  Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
		String username = String.valueOf(claims.get("username"));

		return username;
	}
}

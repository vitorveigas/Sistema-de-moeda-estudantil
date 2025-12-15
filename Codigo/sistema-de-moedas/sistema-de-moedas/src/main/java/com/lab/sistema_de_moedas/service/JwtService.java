package com.lab.sistema_de_moedas.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration:86400000}")
    private long expirationMs;

    private static final SignatureAlgorithm SIGN_ALG = SignatureAlgorithm.HS256;

    private SecretKey getSigningKey() {
        validateSecret(secret);
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    private void validateSecret(String secret) {
        if (secret == null || secret.isBlank()) {
            throw new IllegalStateException("JWT secret não configurado (jwt.secret)");
        }

        if (secret.getBytes(StandardCharsets.UTF_8).length < 32) {
            throw new IllegalStateException("JWT secret muito curto. Use pelo menos 32 bytes.");
        }
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(now());
    }

    private Date now() {
        return new Date();
    }

    public String generateToken(String username) {
        return createToken(new HashMap<>(), username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        final long nowMs = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(nowMs))
                .setExpiration(new Date(nowMs + expirationMs))
                .signWith(getSigningKey(), SIGN_ALG)
                .compact();
    }

    public boolean validateToken(String token, String username) {
        if (token == null || token.isBlank() || username == null || username.isBlank()) {
            return false;
        }
        final String extractedUsername = extractUsername(token);
        return username.equals(extractedUsername) && !isTokenExpired(token);
    }
}

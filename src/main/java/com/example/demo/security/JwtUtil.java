package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component   
public class JwtUtil {

    private static final long EXPIRATION_TIME = 1000 * 60 * 60;
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public JwtUtil() {
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String getUsername(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public long getExpirationMillis() {
        return EXPIRATION_TIME;
    }

    public boolean isTokenValid(String token, String username) {
        return getUsername(token).equals(username) && !isTokenExpired(token);
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private <T> T getClaim(String token, Function<Claims, T> resolver) {
        return resolver.apply(getClaims(token));
    }

    private boolean isTokenExpired(String token) {
        return getClaim(token, Claims::getExpiration).before(new Date());
    }
}

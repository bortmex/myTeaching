package com.rog.teach.catalizator.config;

import com.rog.teach.catalizator.domain.User;
import com.rog.teach.catalizator.domain.UserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.*;

@Component
public class JwtUnil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    public String extractUsername(String authToken) {
        return getClaimsFromToken(authToken)
                .getSubject();
    }

    public Claims getClaimsFromToken(String authToken) {
        String key = Base64.getEncoder().encodeToString(secret.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(authToken)
                .getBody();
    }

    public boolean validateToken(String authToken) {
        return getClaimsFromToken(authToken)
                .getExpiration()
                .before(new Date());
    }

    public String generateToken(User user){
        HashMap<String, Object> claims = new HashMap<>();
        List<UserRole> list = Collections.singletonList(user.getRole());
        claims.put("role", Collections.unmodifiableList(list));
        long expirationSeconds = Long.parseLong(expiration);
        Date creationDate = new Date();
        Date expirationDate = new Date(creationDate.getTime() + expirationSeconds * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(creationDate) //когда был создан токен
                .setExpiration(expirationDate)//когда протухнет
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();

    }
}

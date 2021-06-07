package com.rog.teach.catalizator.config;

import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {
    private final JwtUnil jwtUnil;

    public AuthenticationManager(JwtUnil jwtUnil) {
        this.jwtUnil = jwtUnil;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String authToken = authentication.getAuthorities().toString();

        String username;

        try {
            username = jwtUnil.extractUsername(authToken);
        } catch (Exception e) {
            username = null;
            System.out.println(e);
        }

        if (username != null && jwtUnil.validateToken(authToken)) {
            Claims claims = jwtUnil.getClaimsFromToken(authToken);
            List<String> role = claims.get("role", List.class);
            List<SimpleGrantedAuthority> authorities = role.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    authorities
            );
            return Mono.just(authentication);
        } else {
            return Mono.empty() ;
        }
    }
}

package com.rog.teach.catalizator.controller;

import com.rog.teach.catalizator.config.JwtUnil;
import com.rog.teach.catalizator.domain.User;
import com.rog.teach.catalizator.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
public class UserController {
    private final UserService userService;
    private final JwtUnil jwtUnil;
    private static final ResponseEntity<Object> UNAUTHORIZED = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    public UserController(UserService userService, JwtUnil jwtUnil) {
        this.userService = userService;
        this.jwtUnil = jwtUnil;
    }

    @PostMapping("/login")
    public Mono<ResponseEntity> login(ServerWebExchange swe) {
        return swe.getFormData().flatMap(credentials ->
                userService.findByUsername(credentials.getFirst("username"))
                        .cast(User.class)
                        .map(userDetails ->
                                Objects.equals(
                                        credentials.getFirst("password"),
                                        userDetails.getPassword()
                                )
                                        ? ResponseEntity.ok(jwtUnil.generateToken(userDetails))
                                                : UNAUTHORIZED
                        )
                .defaultIfEmpty(UNAUTHORIZED)
        );
    }
}

package com.jorel.diary.services.Auth.Token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class GenerateTokenService {
    @Value("${api.security.token.secret}")
    private String secretKey;

    public String execute(String email){
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Instant expiresAt = LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));

        return JWT.create()
                .withIssuer("diary")
                .withSubject(email)
                .withExpiresAt(expiresAt)
                .sign(algorithm);
    }
}

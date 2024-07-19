package com.jorel.diary.services.Auth.Token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ValidateTokenService {
    @Value("${api.security.token.secret}")
    private String secretKey;

    public String execute(String token){
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        return JWT.require(algorithm)
                .withIssuer("diary")
                .build()
                .verify(token)
                .getSubject();
    }
}

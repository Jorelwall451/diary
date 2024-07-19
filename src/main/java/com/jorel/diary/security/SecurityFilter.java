package com.jorel.diary.security;

import com.jorel.diary.entities.UserEntity;
import com.jorel.diary.exceptions.Auth.InvalidTokenException;
import com.jorel.diary.exceptions.User.UserEmailNotFoundException;
import com.jorel.diary.repositories.UserRepository;
import com.jorel.diary.services.Auth.Token.ValidateTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.*;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    private final static List<String> EXCLUDED_URLS = Arrays.asList(
            "/auth/login",
            "/auth/register"
    );
    @Autowired
    ValidateTokenService validateToken;
    @Autowired
    UserRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        if(EXCLUDED_URLS.contains(requestURI)){
            filterChain.doFilter(request, response);
            return;
        }

        String token = this.recoverToken(request);
        String login = validateToken.execute(token);

        if(login == null){
            throw new InvalidTokenException();
        }

        Optional<UserEntity> user = repository.findByEmail(login);

        if(user.isEmpty()){
            throw new UserEmailNotFoundException(login);
        }

        SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_USER");
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(role);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");

        if(authHeader == null) {
            throw new InvalidTokenException();
        }

        return authHeader.replace("Bearer ", "");
    }
}

package com.jorel.diary.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Objects;

public class GetAuthenticatedEmail {
    public static String get(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new RuntimeException("Authentication object is null.");
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else if (principal instanceof String) {
            return (String) principal;
        }

        System.err.println("Principal class: " + principal.getClass().getName());

        throw new RuntimeException("Unexpected principal type.");
    }

    public static boolean compare(String email){
        String authenticatedEmail = GetAuthenticatedEmail.get();
        System.out.println(authenticatedEmail + "  " + email);
        return Objects.equals(authenticatedEmail, email);
    }
}

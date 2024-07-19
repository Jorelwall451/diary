package com.jorel.diary.exceptions.Auth;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(){
        super("The token is not valid");
    }
}

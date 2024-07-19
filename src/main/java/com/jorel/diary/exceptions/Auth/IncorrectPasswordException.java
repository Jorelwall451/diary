package com.jorel.diary.exceptions.Auth;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(){
        super("Incorrect password");
    }
}

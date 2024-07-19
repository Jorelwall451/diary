package com.jorel.diary.exceptions.Auth;

public class EmailOrPasswordIncorrectException extends RuntimeException {
    public EmailOrPasswordIncorrectException(){
        super("Email or Password incorrect");
    }
}

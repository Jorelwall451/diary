package com.jorel.diary.exceptions.Auth;

public class UnauthorizedEmailException extends RuntimeException {
    public  UnauthorizedEmailException(){
        super("You don't have authorization.");
    }
}

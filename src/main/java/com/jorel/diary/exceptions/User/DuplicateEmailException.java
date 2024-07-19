package com.jorel.diary.exceptions.User;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email){
        super("Already exists the email " + email + ".");
    }
}

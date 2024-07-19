package com.jorel.diary.exceptions.User;

public class UserEmailNotFoundException extends RuntimeException {
    public UserEmailNotFoundException(String email){
        super("Don't exists a user with the email " + email + ".");
    }
}

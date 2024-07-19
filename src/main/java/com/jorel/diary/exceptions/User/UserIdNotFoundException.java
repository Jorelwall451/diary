package com.jorel.diary.exceptions.User;

import java.util.UUID;

public class UserIdNotFoundException extends RuntimeException {
    public UserIdNotFoundException(UUID id){
        super("Don't exists a user with the id " + id + ".");
    }
}

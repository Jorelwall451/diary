package com.jorel.diary.exceptions.User;

public class DuplicateNameException extends RuntimeException {
    public DuplicateNameException(String name){
        super("Already exists the name " + name + ".");
    }
}

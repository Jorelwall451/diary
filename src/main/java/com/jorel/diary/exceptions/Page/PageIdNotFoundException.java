package com.jorel.diary.exceptions.Page;

import java.util.UUID;

public class PageIdNotFoundException extends RuntimeException {
    public PageIdNotFoundException(Long id, UUID userId){
        super("Cannot found a page with the id " + id + " in the user with the id " + userId + ".");
    }
}

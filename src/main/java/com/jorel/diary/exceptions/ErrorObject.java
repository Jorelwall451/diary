package com.jorel.diary.exceptions;

import java.time.LocalDateTime;

public record ErrorObject(
        String error,
        Integer status,
        LocalDateTime timestamp ,
        String message
){

}

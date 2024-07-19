package com.jorel.diary.exceptions;

import com.jorel.diary.exceptions.Auth.EmailOrPasswordIncorrectException;
import com.jorel.diary.exceptions.Auth.IncorrectPasswordException;
import com.jorel.diary.exceptions.Auth.InvalidTokenException;
import com.jorel.diary.exceptions.Auth.UnauthorizedEmailException;
import com.jorel.diary.exceptions.Page.PageIdNotFoundException;
import com.jorel.diary.exceptions.User.DuplicateEmailException;
import com.jorel.diary.exceptions.User.DuplicateNameException;
import com.jorel.diary.exceptions.User.UserEmailNotFoundException;
import com.jorel.diary.exceptions.User.UserIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateNameException.class)
    public ResponseEntity<ErrorObject> duplicateNameException(DuplicateNameException exception){
        ErrorObject errorObject = new ErrorObject("Duplicate Name Exception", HttpStatus.CONFLICT.value(), LocalDateTime.now(), exception.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorObject);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ErrorObject> duplicateEmailException(DuplicateEmailException exception){
        ErrorObject errorObject = new ErrorObject("Duplicate Email Exception", HttpStatus.CONFLICT.value(), LocalDateTime.now(), exception.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorObject);
    }

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorObject> userIdNotFoundException(UserIdNotFoundException exception){
        ErrorObject errorObject = new ErrorObject("User Id Not Found.", HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
    }

    @ExceptionHandler(UserEmailNotFoundException.class)
    public ResponseEntity<ErrorObject> userEmailNotFoundException(UserEmailNotFoundException exception){
        ErrorObject errorObject = new ErrorObject("User Email Not Found.", HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ErrorObject> invalidTokenException(InvalidTokenException exception){
        ErrorObject errorObject = new ErrorObject("Invalid Token Exception", HttpStatus.FORBIDDEN.value(), LocalDateTime.now(), exception.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorObject);
    }

    @ExceptionHandler(EmailOrPasswordIncorrectException.class)
    public ResponseEntity<ErrorObject> emailOrPasswordIncorrectException(EmailOrPasswordIncorrectException exception){
        ErrorObject errorObject = new ErrorObject("Email Or Password Incorrect Exception", HttpStatus.UNAUTHORIZED.value(), LocalDateTime.now(), exception.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorObject);
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ErrorObject> incorrectPasswordException(IncorrectPasswordException exception){
        ErrorObject errorObject = new ErrorObject("Incorrect Password Exception", HttpStatus.UNAUTHORIZED.value(), LocalDateTime.now(), exception.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorObject);
    }


    @ExceptionHandler(PageIdNotFoundException.class)
    public ResponseEntity<Object> pageIdNotFoundException(PageIdNotFoundException exception){
        ErrorObject errorObject = new ErrorObject("Page Id Not Found", HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorObject> handleBadRequest(MethodArgumentNotValidException exception) {
        ErrorObject errorObject = new ErrorObject("Bad Request", HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
    }

    @ExceptionHandler(UnauthorizedEmailException.class)
    public ResponseEntity<ErrorObject> handleUnauthorizedEmailException(UnauthorizedEmailException exception){
        ErrorObject errorObject = new ErrorObject("Unauthorized", HttpStatus.UNAUTHORIZED.value(), LocalDateTime.now(), exception.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorObject);
    }
}

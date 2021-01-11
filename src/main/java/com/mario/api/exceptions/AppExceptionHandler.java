package com.mario.api.exceptions;

import com.mario.api.errors.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = UserServiceException.class)
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {

        ErrorMessage errorMessage = new ErrorMessage(new Date(System.currentTimeMillis()), ex.getMessage());
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RepositoryServiceException.class)
    public ResponseEntity<Object> handleRepositoryServiceException(RepositoryServiceException ex, WebRequest request) {

        ErrorMessage errorMessage = new ErrorMessage(new Date(System.currentTimeMillis()), ex.getMessage());
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TokenServiceException.class)
    public ResponseEntity<Object> handleTokenServiceException(TokenServiceException ex, WebRequest request) {

        ErrorMessage errorMessage = new ErrorMessage(new Date(System.currentTimeMillis()), ex.getMessage());
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.FORBIDDEN);
    }




}

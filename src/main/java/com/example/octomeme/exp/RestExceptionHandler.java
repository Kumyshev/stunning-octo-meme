package com.example.octomeme.exp;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ ComixNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(Exception exception, WebRequest request) {
        return handleExceptionInternal(exception, "Comix not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ ComixNotFoundException.class, ConstraintViolationException.class,
            DataIntegrityViolationException.class })
    protected ResponseEntity<Object> handleBadRequest(Exception exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getLocalizedMessage(), new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);
    }
}

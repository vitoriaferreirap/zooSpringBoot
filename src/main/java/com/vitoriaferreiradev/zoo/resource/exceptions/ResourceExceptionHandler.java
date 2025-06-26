package com.vitoriaferreiradev.zoo.resource.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vitoriaferreiradev.zoo.services.exceptions.DuplicatedAnimalException;
import com.vitoriaferreiradev.zoo.services.exceptions.InvalidDataException;
import com.vitoriaferreiradev.zoo.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
// Tratador global de exceções

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // Handle é um método que trata exceções
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DuplicatedAnimalException.class)
    public ResponseEntity<StandardError> duplicatedAnimal(DuplicatedAnimalException e, HttpServletRequest request) {
        String error = "Duplicated animal";
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<StandardError> invalidData(InvalidDataException e, HttpServletRequest request) {
        String error = "Invalid data";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
//* Functionality */
/*
  Exception handler to manage the custom exceptions and provide
  meaningful error messages.
*/ 


package com.example.demo.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(DataGenerationException.class)
    public ResponseEntity<String> handleDataGenerationException(DataGenerationException ex) {
        return new ResponseEntity<>("Data Generation Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<String> handleJsonProcessingException(JsonProcessingException ex) {
        return new ResponseEntity<>("JSON Processing Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

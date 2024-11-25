package com.invoice.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Global handler for CustomException
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        // Return custom message for CustomException with BAD_REQUEST status
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invoice number must contain only digits.");
    }

    // Global handler for all other exceptions (catch-all handler)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        // Log the exception or print the stack trace
        ex.printStackTrace();  // You can replace this with a logger for production
        
        // Return a generic error message with INTERNAL_SERVER_ERROR status
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("An unexpected error occurred.");
    }
}

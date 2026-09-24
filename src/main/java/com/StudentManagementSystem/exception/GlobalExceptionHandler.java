package com.StudentManagementSystem.exception;

import com.StudentManagementSystem.Dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStdNotFoundException(StdNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(
                "USER_NOT_FOUND", ex.getMessage()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        HashMap<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        });
        StringBuilder errorMsg = new StringBuilder();
        for (String field : fieldErrors.keySet()) {
            errorMsg.append(field).append(" : ").append(fieldErrors.get(field)).append("\n");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(
                "INVALID_INPUT", errorMsg.toString()

        ));

    }
}
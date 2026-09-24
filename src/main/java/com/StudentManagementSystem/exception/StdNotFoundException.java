package com.StudentManagementSystem.exception;

public class StdNotFoundException extends RuntimeException{
    public StdNotFoundException(String errorMessage){
        super(errorMessage);
    }
}

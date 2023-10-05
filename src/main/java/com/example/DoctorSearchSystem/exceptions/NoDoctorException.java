package com.example.DoctorSearchSystem.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class NoDoctorException extends RuntimeException{
    public NoDoctorException(String message) {
        super(message);
    }
}

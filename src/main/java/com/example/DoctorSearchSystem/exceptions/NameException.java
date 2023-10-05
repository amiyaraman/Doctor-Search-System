package com.example.DoctorSearchSystem.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class NameException extends RuntimeException{

    public NameException(String message) {
        super(message);
    }
}

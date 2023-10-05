package com.example.DoctorSearchSystem.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DiseaseNotFound extends RuntimeException{
    public DiseaseNotFound(String message){
        super(message);
    }
}

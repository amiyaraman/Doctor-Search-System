package com.example.DoctorSearchSystem.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class MyErrorResponse extends ResponseEntityExceptionHandler {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public MyErrorResponse(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
    public MyErrorResponse(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        this.errors =new ArrayList<>();
        errors.add(error);
    }
}

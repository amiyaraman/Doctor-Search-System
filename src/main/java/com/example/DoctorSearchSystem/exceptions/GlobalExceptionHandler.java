package com.example.DoctorSearchSystem.exceptions;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors= new ArrayList<>();

        e.getBindingResult().getAllErrors().forEach((err)->{
            String fieldName = ((FieldError) err).getField();
            String errorMessage = err.getDefaultMessage();
            errors.add(fieldName+": "+errorMessage);

        });

        MyErrorResponse errorResponse=new MyErrorResponse(HttpStatus.BAD_REQUEST,"Validation Failed",errors);
        return new ResponseEntity<>(errorResponse,errorResponse.getStatus());
    }

    @ExceptionHandler(CityException.class)
    ResponseEntity<MyErrorResponse> CityExceptionHandler(CityException e){
        MyErrorResponse errorResponse=new MyErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage(),e.getMessage());
        return new ResponseEntity<>(errorResponse,errorResponse.getStatus());
    }
    @ExceptionHandler(EmailException.class)
    ResponseEntity<MyErrorResponse> emailExceptionHandler(EmailException e){
        MyErrorResponse errorResponse=new MyErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage(),e.getMessage());
        return new ResponseEntity<>(errorResponse,errorResponse.getStatus());
    }
    @ExceptionHandler(NameException.class)
    ResponseEntity<MyErrorResponse> nameExceptionHandler(NumberException e){
        MyErrorResponse errorResponse=new MyErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage(),e.getMessage());
        return new ResponseEntity<>(errorResponse,errorResponse.getStatus());
    }
    @ExceptionHandler(NoDoctorException.class)
    ResponseEntity<MyErrorResponse> noDoctorExceptionHandler(NoDoctorException e){
        MyErrorResponse errorResponse=new MyErrorResponse(HttpStatus.NOT_FOUND,e.getMessage(),e.getMessage());
        return new ResponseEntity<>(errorResponse,errorResponse.getStatus());
    }
    @ExceptionHandler(NumberException.class)
    ResponseEntity<MyErrorResponse> numberExceptionHandler(NumberException e){
        MyErrorResponse errorResponse=new MyErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage(),e.getMessage());
        return new ResponseEntity<>(errorResponse,errorResponse.getStatus());
    }
    @ExceptionHandler(PatientException.class)
    ResponseEntity<MyErrorResponse> patientExceptionHandler(PatientException e){

        MyErrorResponse errorResponse=new MyErrorResponse(HttpStatus.NOT_FOUND,e.getMessage(),e.getMessage());

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DiseaseNotFound.class)
    ResponseEntity<MyErrorResponse> diseaseNotFoundExceptionHandler(DiseaseNotFound e){
        MyErrorResponse errorResponse=new MyErrorResponse(HttpStatus.NOT_FOUND,e.getMessage(),e.getMessage());
        return new ResponseEntity<>(errorResponse,errorResponse.getStatus());
    }
    @ExceptionHandler(OutSideCityDomainException.class)
    ResponseEntity<String> OutSideCityDomainExceptionHandler(OutSideCityDomainException e){
        MyErrorResponse errorResponse=new MyErrorResponse(HttpStatus.NOT_FOUND,e.getMessage(),e.getMessage());
        return new ResponseEntity<>("{\n message:"+e.getMessage()+"\n}",errorResponse.getStatus());
    }






}

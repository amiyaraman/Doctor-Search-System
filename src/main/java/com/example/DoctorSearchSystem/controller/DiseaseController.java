package com.example.DoctorSearchSystem.controller;

import com.example.DoctorSearchSystem.dtos.RequestDto.DiseaseDto;
import com.example.DoctorSearchSystem.service.DiseaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/diseases")
public class DiseaseController {

    @Autowired
    DiseaseService diseaseService;

    @PostMapping("/add-disease")
    public ResponseEntity<String> addDisease(@Valid @RequestBody DiseaseDto diseaseDto){
            String message = diseaseService.addDisease(diseaseDto);

            return new ResponseEntity<>(message, HttpStatus.CREATED);

    }
}

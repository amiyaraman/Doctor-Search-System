package com.example.DoctorSearchSystem.controller;

import com.example.DoctorSearchSystem.dtos.RequestDto.PatientDto;
import com.example.DoctorSearchSystem.dtos.ResponseDto.DoctorList;
import com.example.DoctorSearchSystem.service.PatientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {

    @Autowired
    PatientServiceImpl patientService;

    @PostMapping("/add-patient")
    public ResponseEntity<String> addPatient(@Valid @RequestBody PatientDto patientDto){
            String message = patientService.addPatient(patientDto);
            System.out.println("here : " +patientDto);


            return new ResponseEntity<>(message, HttpStatus.CREATED);

    }

    @GetMapping("/find-doctors")
    public ResponseEntity<List<DoctorList>> getDoctors(@Valid @RequestParam Integer patientId){

            List<DoctorList> doctorList = patientService.getDoctors(patientId);

            return new ResponseEntity<>(doctorList, HttpStatus.OK);

    }

    @DeleteMapping("/delete-patient")
    public ResponseEntity<String> deletePatient(@Valid @RequestParam Integer patientId){

            String message = patientService.deletePatient(patientId);
            return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
    }
}

package com.example.DoctorSearchSystem.controller;

import com.example.DoctorSearchSystem.dtos.RequestDto.DoctorDto;
import com.example.DoctorSearchSystem.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add-doctor")
    public ResponseEntity<String> addDoctor(@Valid @RequestBody DoctorDto doctorDto){

            String message = doctorService.addDoctor(doctorDto);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-doctor")
    public ResponseEntity<String> deleteDoctor(@Valid @RequestParam Integer doctorId){

            String message = doctorService.deleteDoctor(doctorId);

            return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
    }
}

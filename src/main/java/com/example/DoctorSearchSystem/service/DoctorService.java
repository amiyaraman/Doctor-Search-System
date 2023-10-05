package com.example.DoctorSearchSystem.service;

import com.example.DoctorSearchSystem.dtos.RequestDto.DoctorDto;

public interface DoctorService {
     String deleteDoctor(Integer doctorId);
     String addDoctor(DoctorDto doctorDto);
}

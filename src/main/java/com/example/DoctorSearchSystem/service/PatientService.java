package com.example.DoctorSearchSystem.service;

import com.example.DoctorSearchSystem.dtos.RequestDto.PatientDto;
import com.example.DoctorSearchSystem.dtos.ResponseDto.DoctorList;

import java.util.List;

public interface PatientService {

     List<DoctorList> getDoctors(Integer patientId);

     String addPatient(PatientDto patientDto);

     String deletePatient(Integer patientId);
}

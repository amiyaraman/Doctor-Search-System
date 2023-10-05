package com.example.DoctorSearchSystem.mapper;

import com.example.DoctorSearchSystem.dtos.RequestDto.PatientDto;
import com.example.DoctorSearchSystem.models.Patient;
import org.mapstruct.Mapper;


@Mapper
public interface PatientMapper {

    PatientDto patientToPatientDto (Patient patient);

    Patient patientDtoToPatient (PatientDto patientDto);
}

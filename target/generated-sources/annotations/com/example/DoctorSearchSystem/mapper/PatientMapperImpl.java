package com.example.DoctorSearchSystem.mapper;

import com.example.DoctorSearchSystem.dtos.RequestDto.PatientDto;
import com.example.DoctorSearchSystem.dtos.RequestDto.PatientDto.PatientDtoBuilder;
import com.example.DoctorSearchSystem.models.Patient;
import com.example.DoctorSearchSystem.models.Patient.PatientBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-05T20:46:26+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientDto patientToPatientDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDtoBuilder patientDto = PatientDto.builder();

        patientDto.name( patient.getName() );
        patientDto.city( patient.getCity() );
        patientDto.email( patient.getEmail() );
        patientDto.mobileNo( patient.getMobileNo() );
        patientDto.symptom( patient.getSymptom() );

        return patientDto.build();
    }

    @Override
    public Patient patientDtoToPatient(PatientDto patientDto) {
        if ( patientDto == null ) {
            return null;
        }

        PatientBuilder patient = Patient.builder();

        patient.name( patientDto.getName() );
        patient.city( patientDto.getCity() );
        patient.email( patientDto.getEmail() );
        patient.mobileNo( patientDto.getMobileNo() );
        patient.symptom( patientDto.getSymptom() );

        return patient.build();
    }
}

package com.example.DoctorSearchSystem.mapper;

import com.example.DoctorSearchSystem.dtos.RequestDto.DoctorDto;
import com.example.DoctorSearchSystem.dtos.RequestDto.DoctorDto.DoctorDtoBuilder;
import com.example.DoctorSearchSystem.enums.City;
import com.example.DoctorSearchSystem.models.Doctor;
import com.example.DoctorSearchSystem.models.Doctor.DoctorBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-05T21:40:45+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public DoctorDto doctorToDoctorDto(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorDtoBuilder doctorDto = DoctorDto.builder();

        doctorDto.name( doctor.getName() );
        if ( doctor.getCity() != null ) {
            doctorDto.city( doctor.getCity().name() );
        }
        doctorDto.email( doctor.getEmail() );
        doctorDto.mobileNo( doctor.getMobileNo() );
        doctorDto.speciality( doctor.getSpeciality() );

        return doctorDto.build();
    }

    @Override
    public Doctor doctorDtoToDoctor(DoctorDto doctorDto) {
        if ( doctorDto == null ) {
            return null;
        }

        DoctorBuilder doctor = Doctor.builder();

        doctor.name( doctorDto.getName() );
        if ( doctorDto.getCity() != null ) {
            doctor.city( Enum.valueOf( City.class, doctorDto.getCity() ) );
        }
        doctor.email( doctorDto.getEmail() );
        doctor.mobileNo( doctorDto.getMobileNo() );
        doctor.speciality( doctorDto.getSpeciality() );

        return doctor.build();
    }
}

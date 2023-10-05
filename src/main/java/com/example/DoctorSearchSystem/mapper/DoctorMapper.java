package com.example.DoctorSearchSystem.mapper;

import com.example.DoctorSearchSystem.dtos.RequestDto.DoctorDto;
import com.example.DoctorSearchSystem.models.Doctor;
import org.mapstruct.Mapper;


@Mapper
public interface DoctorMapper {

    DoctorDto doctorToDoctorDto (Doctor doctor);

    Doctor doctorDtoToDoctor (DoctorDto doctorDto);

}

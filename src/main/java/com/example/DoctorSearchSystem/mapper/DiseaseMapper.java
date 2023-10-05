package com.example.DoctorSearchSystem.mapper;

import com.example.DoctorSearchSystem.dtos.RequestDto.DiseaseDto;
import com.example.DoctorSearchSystem.models.Disease;
import org.mapstruct.Mapper;


@Mapper
public interface DiseaseMapper {

    DiseaseDto diseaseToDiseaseDto (Disease disease);

    Disease diseaseDtoToDisease (DiseaseDto diseaseDto);
}

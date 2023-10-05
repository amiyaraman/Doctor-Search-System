package com.example.DoctorSearchSystem.mapper;

import com.example.DoctorSearchSystem.dtos.RequestDto.DiseaseDto;
import com.example.DoctorSearchSystem.dtos.RequestDto.DiseaseDto.DiseaseDtoBuilder;
import com.example.DoctorSearchSystem.models.Disease;
import com.example.DoctorSearchSystem.models.Disease.DiseaseBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-05T18:56:55+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class DiseaseMapperImpl implements DiseaseMapper {

    @Override
    public DiseaseDto diseaseToDiseaseDto(Disease disease) {
        if ( disease == null ) {
            return null;
        }

        DiseaseDtoBuilder diseaseDto = DiseaseDto.builder();

        diseaseDto.diseaseName( disease.getDiseaseName() );
        diseaseDto.speciality( disease.getSpeciality() );

        return diseaseDto.build();
    }

    @Override
    public Disease diseaseDtoToDisease(DiseaseDto diseaseDto) {
        if ( diseaseDto == null ) {
            return null;
        }

        DiseaseBuilder disease = Disease.builder();

        disease.diseaseName( diseaseDto.getDiseaseName() );
        disease.speciality( diseaseDto.getSpeciality() );

        return disease.build();
    }
}

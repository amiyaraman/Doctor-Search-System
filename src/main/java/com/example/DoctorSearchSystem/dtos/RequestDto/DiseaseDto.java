package com.example.DoctorSearchSystem.dtos.RequestDto;

import com.example.DoctorSearchSystem.enums.Speciality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseDto {

    private String diseaseName;

    private Speciality speciality;
}

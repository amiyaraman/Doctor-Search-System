package com.example.DoctorSearchSystem.service;

import com.example.DoctorSearchSystem.dtos.RequestDto.DiseaseDto;
import com.example.DoctorSearchSystem.mapper.DiseaseMapper;
import com.example.DoctorSearchSystem.models.Disease;
import com.example.DoctorSearchSystem.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    DiseaseRepository diseaseRepository;

    @Autowired
    DiseaseMapper diseaseMapper;


    public String addDisease(DiseaseDto diseaseDto) {
        Disease disease = diseaseMapper.diseaseDtoToDisease(diseaseDto);

        diseaseRepository.save(disease);

        return "Disease is stored with it's related category";
    }
}

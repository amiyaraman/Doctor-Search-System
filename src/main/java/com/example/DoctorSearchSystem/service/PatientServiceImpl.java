package com.example.DoctorSearchSystem.service;

import com.example.DoctorSearchSystem.dtos.RequestDto.DoctorDto;
import com.example.DoctorSearchSystem.dtos.RequestDto.PatientDto;
import com.example.DoctorSearchSystem.dtos.ResponseDto.DoctorList;
import com.example.DoctorSearchSystem.enums.Speciality;
import com.example.DoctorSearchSystem.exceptions.*;
import com.example.DoctorSearchSystem.mapper.DoctorMapper;
import com.example.DoctorSearchSystem.mapper.PatientMapper;
import com.example.DoctorSearchSystem.models.Disease;
import com.example.DoctorSearchSystem.models.Doctor;
import com.example.DoctorSearchSystem.models.Patient;
import com.example.DoctorSearchSystem.repository.DiseaseRepository;
import com.example.DoctorSearchSystem.repository.DoctorRepository;
import com.example.DoctorSearchSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DiseaseRepository diseaseRepository;

    @Autowired
    PatientMapper patientMapper;

    @Autowired
    DoctorMapper doctorMapper;

    public String addPatient(PatientDto patientDto) {
        Patient patient = patientMapper.patientDtoToPatient(patientDto);

        if(patient.getName().length() < 3){
            throw new NameException("The length of the name should be 3 at least.");
        }
        if(patient.getCity().length() > 20){
            throw new CityException("The length of the city name should be 20 at max");
        }
        if(!patient.getEmail().contains("@gmail.com")){
            throw new EmailException("Proper email id needed");
        }
        if(patient.getMobileNo().length() < 10){
            throw new NumberException("Given mobile number is not valid, check that again.");
        }

        patientRepository.save(patient);

        return "Patient is added to the database";
    }

    public List<DoctorList> getDoctors(Integer patientId) {
        List<Doctor> doctorList = doctorRepository.findAll();
        System.out.println(doctorList);

        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if(patientOptional.isEmpty()){
            throw new PatientException("No patient with given id");
        }

        Patient patient = patientOptional.get();

        String symptom = patient.getSymptom();
        String city = patient.getCity();

        Disease disease = diseaseRepository.findByDiseaseName(symptom);
        if(disease==null){
            throw  new DiseaseNotFound("No Disease With the symptom of patient exist");
        }
        Speciality speciality = disease.getSpeciality();


        List<Doctor> list1 = new ArrayList<>();
        for(Doctor doctor : doctorList){
            if(doctor.getSpeciality().toString().equals(speciality.toString()) && doctor.getCity().toString().equals(city)){
                list1.add(doctor);
            }
        }
        if(list1.isEmpty()){
            throw new NoDoctorException("There isn’t any doctor present at your location for your symptom");
        }

        List<Doctor> list2 = new ArrayList<>();
        for(Doctor doctor : list1){
            if(doctor.getCity().toString().equals(city)){
                list2.add(doctor);
            }
        }
        if(list2.isEmpty()){
            throw new CityException("We are still waiting to expand to your location");
        }

        List<DoctorList> returnlist = new ArrayList<>();
        for(Doctor doctor : list2){
            DoctorDto doctorDto = doctorMapper.doctorToDoctorDto(doctor);
            DoctorList doclist=DoctorList.builder().name(doctorDto.getName())
                    .mobileNo(doctorDto.getMobileNo())
                            .city(doctorDto.getCity().toString()).build();
            returnlist.add(doclist);
        }

        return returnlist;
    }

    public String deletePatient(Integer patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if(patientOptional.isEmpty()){
            throw new PatientException("No patient with given id");
        }

        Patient patient = patientOptional.get();

        patientRepository.delete(patient);

        return "Patient is deleted from the database successfully.";
    }
}

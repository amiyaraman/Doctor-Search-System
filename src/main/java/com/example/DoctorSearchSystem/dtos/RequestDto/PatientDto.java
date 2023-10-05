package com.example.DoctorSearchSystem.dtos.RequestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    @Size(min = 3 ,message = "Name must be more then 3 character")
    private String name;


    @Size( max = 20 ,message = "city must no be more then 20 character")
    private String city;

    @Email
    private String email;

    @Size(max = 10,min = 10,message = "Phone number must be of  10 numbers")
    private String mobileNo;

    private String symptom;

}

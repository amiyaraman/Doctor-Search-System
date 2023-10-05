package com.example.DoctorSearchSystem.dtos.RequestDto;

import com.example.DoctorSearchSystem.enums.Speciality;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {

    @Size(min = 3 ,message = "Name must be more then 3 character")
    private String name;


    @Size(max = 20 ,message = "city must no be more then 20 character")
    private String city;

    @Email(message = "Email format should be correct ")
    private String email;


    @Size(max = 10,min = 10,message = "Phone number can not be more then 10")
    private String mobileNo;

    private Speciality speciality;
}

package com.example.DoctorSearchSystem.dtos.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorList {

    private String name;

    private String mobileNo;

    private String city;

}

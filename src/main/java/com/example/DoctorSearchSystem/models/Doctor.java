package com.example.DoctorSearchSystem.models;

import com.example.DoctorSearchSystem.enums.City;
import com.example.DoctorSearchSystem.enums.Speciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "doctors")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer docId;

    private String name;

    @Enumerated(EnumType.STRING)
    private City city;

    private String email;

    private String mobileNo;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

}

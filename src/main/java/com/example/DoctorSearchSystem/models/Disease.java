package com.example.DoctorSearchSystem.models;

import com.example.DoctorSearchSystem.enums.Speciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diseases")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer diseaseId;

    private String diseaseName;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;
}

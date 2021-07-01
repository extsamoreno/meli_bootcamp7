package com.example.muelitas.dto;

import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private String medicalInsurance;
}

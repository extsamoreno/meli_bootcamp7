package com.example.app_consultorio.dto;

import lombok.Data;

@Data
public class PatientDTO {

    private Long id;
    private String name;
    private String dni;
    private String address;
    private String social_work;
}

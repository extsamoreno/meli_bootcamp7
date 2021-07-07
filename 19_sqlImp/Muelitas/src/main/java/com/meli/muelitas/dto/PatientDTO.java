package com.meli.muelitas.dto;

import lombok.Data;

@Data
public class PatientDTO {

    private Long id;

    private String name;

    private String nit;

    private Integer age;

    private Integer phoneNumber;
}

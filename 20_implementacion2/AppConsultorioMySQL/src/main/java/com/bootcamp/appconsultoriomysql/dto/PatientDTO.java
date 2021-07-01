package com.bootcamp.appconsultoriomysql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private String dni;
    private String name;
    private String lastname;
}

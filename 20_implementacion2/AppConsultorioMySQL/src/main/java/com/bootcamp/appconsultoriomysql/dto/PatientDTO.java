package com.bootcamp.appconsultoriomysql.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private String dni;
    private String name;
    private String lastname;
}

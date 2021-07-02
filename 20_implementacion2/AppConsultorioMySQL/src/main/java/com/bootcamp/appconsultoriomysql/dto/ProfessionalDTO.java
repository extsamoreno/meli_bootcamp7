package com.bootcamp.appconsultoriomysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalDTO {

    private String dni;
    private String name;
    private String lastname;

}

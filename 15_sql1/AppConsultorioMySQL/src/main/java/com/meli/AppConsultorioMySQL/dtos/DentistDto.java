package com.meli.AppConsultorioMySQL.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistDto {
    private Long id;
    private String dni;
    private String name;
    private String lastname;
}

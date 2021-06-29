package com.meli.consultorio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfesionalResponse {

    private int id;
    private String nombre;
    private String legajo;
    private String matricula;

}

package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

public class StudentDTO {

    @NotBlank( message = "El nombre del alumno no puede estar vacío.")  // not null + not empty string
    @Pattern(regexp = "^[A-Z].*",  message ="El nombre del alumno comenzar con mayúscula." )
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres." )
    private String studentName;

    @NotEmpty ( message = "La lista no puede ser vacía.")
    @Valid
    private List<SubjectDTO> subjects;

    public StudentDTO(){
        subjects = new ArrayList<>();
    }

}
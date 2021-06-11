package com.digitalhouse.obtenerdiploma.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
public class StudentDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String studentName;

    @Valid
    @NotEmpty(message = "La lista no puede ser vacía.")
    private List<SubjectDTO> subjects;
}

package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Pattern(regexp = "\\b([A-Z])(\\S*?)\\b", message = "El nombre del alumno comenzar con mayúscula.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String studentName;

    @NotEmpty(message = "La lista no puede ser vacía.")
    private @Valid List<SubjectDTO> subjects;
}
package com.digitalhouse.obtenerdiploma.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO{
    @NotEmpty(message = "El nombre del alumno no puede estar vacío.")
    @Size(max=50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "[A-Z][a-z]*", message = "El nombre del alumno comenzar con mayúscula.")
    private String studentName;

    @NotEmpty (message = "La lista no puede ser vacía.")
    private List<@Valid SubjectDTO> subjects;

}

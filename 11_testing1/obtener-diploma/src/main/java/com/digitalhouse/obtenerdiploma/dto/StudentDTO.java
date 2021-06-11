package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @NotNull(message = "El nombre del alumno no puede estar vacío.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "^.*[A-Z][a-z0-9_-áéíóú]{3,19}.*$", message = "El nombre del alumno comenzar con mayúscula.")
    private String studentName;

    @NotNull(message = "La lista no puede ser vacia.")
    @Size(min = 1, message = "La lista no puede ser vacia.")
    @Valid
    private List<SubjectDTO> subjects;

}

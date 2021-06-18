package com.digitalhouse.obtenerdiploma.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    @NotNull(message = "El nombre del alumno no puede ser nula.")
    @NotEmpty(message = "El nombre del alumno no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno comenzar con mayúscula.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String studentName;
    @Valid
    @NotNull(message = "La lista no puede ser nula.")
    @NotEmpty(message = "La lista no puede ser vacía.")
    private List< SubjectDTO> subjects;
}

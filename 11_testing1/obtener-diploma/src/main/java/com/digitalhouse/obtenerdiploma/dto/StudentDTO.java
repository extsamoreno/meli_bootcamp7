package com.digitalhouse.obtenerdiploma.dto;

import lombok.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    private String studentName;
    @NotEmpty(message = "La lista no puede ser vacía")
    private List<@Valid SubjectDTO> subjects;
}


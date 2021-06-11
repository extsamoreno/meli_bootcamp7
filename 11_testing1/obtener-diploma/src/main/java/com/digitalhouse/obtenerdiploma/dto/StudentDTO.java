package com.digitalhouse.obtenerdiploma.dto;

import java.util.List;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    private String studentName;
    @NotEmpty(message = "La lista no puede ser vacía")
    private List<@Valid SubjectDTO> subjects;
}

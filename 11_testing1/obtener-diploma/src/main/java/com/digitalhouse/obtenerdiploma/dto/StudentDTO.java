package com.digitalhouse.obtenerdiploma.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotEmpty(message = "El nombre del alumno no puede estar vacío.")
    //@Pattern(regexp = "\\b([A-Z])(\\S*?)\\b", message = "El nombre del alumno debe comenzar con mayúscula.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula.")
    @Size(min = 1, max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String studentName;


    @NotEmpty(message = "La lista no puede ser vacía.")
    private @Valid List<SubjectDTO> subjects;



}

package com.example.demo.dto;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
public class StudentDTO {

    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre del alumno debe comenzar con mayúscula.")
    @NotNull(message="El nombre del alumno no puede estar vacío")
    private String studentName;

    @NotNull(message="La lista no puede ser vacía.")
    private List<@Valid SubjectDTO> subjects;

}

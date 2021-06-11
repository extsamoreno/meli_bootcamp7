package com.example.diplomatesting.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotEmpty(message = "El nombre del alumno no debe ser vacío.")
    @Size(max=50, message = "La longitud del nombre no debe exceder los 50 caracteres.")
    @Pattern(regexp = "[A-Z\\u00d1][a-zà-ÿ\\u00f1]*", message = "El nombre debe comenzar con mayúscula.")
    private String studentName;

    @NotEmpty(message = "La lista de materias no debe estar vacía")
    private List<@Valid SubjectDTO> subjects;

}

package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@AllArgsConstructor
@Data
public class StudentDTO {
    @NotBlank (message = "El nombre del alumno no puede estar vacio")
    @Pattern(regexp = "^[A-Z]([A-Za-z])*", message = "El nombre del alumno comenzar con mayuscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    private String studentName;
    @NotEmpty(message = "La lista no puede ser vacia")
    private List<@Valid SubjectDTO> subjects;

    public StudentDTO() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

}

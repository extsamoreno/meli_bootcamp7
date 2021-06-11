package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDTO {

    @Pattern(regexp="^[A-Z].*",message="El nombre del alumno debe comenzar con mayúscula")
    @NotEmpty(message = "El nombre de alumno no puede estar vacio")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    private String studentName;
    @NotEmpty(message = "La lista no puede ser vacía.")
    @Size(max = 60, message = "La cantidad de materias debe ser menor a 60")
    private List<@Valid SubjectDTO> subjects;

    public StudentDTO() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

}

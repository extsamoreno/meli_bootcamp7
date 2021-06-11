package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDTO {

    @NotNull(message = "studentName es un campo obligatorio")
    @NotEmpty(message = "El nombre del alumno no puede estar vacío")
    @Pattern(regexp = "\\b([A-Z])(\\S*?)\\b", message = "El nombre del alumno debe comenzar con mayúscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String studentName;

    @NotNull(message = "subjects es un campo obligatorio")
    @NotEmpty(message = "La lista no puede estar vacía")
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

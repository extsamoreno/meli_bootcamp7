package com.validacionesyexcepciones.validacionesyexcepciones.dto;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


@Valid
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no puede estar vacío.")
    @Size(max = 50,message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "[A-ZÖ][a-zö]+",message = "El nombre del alumno comenzar con mayúscula.")
    private String name;
    @NotEmpty(message = "La lista no puede ser vacía.")
    private List<SubjectDTO> subjects;

    public StudentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

}

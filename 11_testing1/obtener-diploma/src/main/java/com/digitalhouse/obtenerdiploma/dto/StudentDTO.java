package com.digitalhouse.obtenerdiploma.dto;

import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDTO {
    @Valid
    @NotNull( message="Name cannot be null")
    @Size(min = 5, max = 50, message = "Max size 50 character ^[A-Z].*")
    private String name;

    @Valid
    @NotEmpty(message = "List subjects not empty")
    private List<SubjectDTO> subjects;

    public StudentDTO() {
    }

    public StudentDTO(
            @NotNull(message = "Name cannot be null")
            @Size(max = 50, message = "Max size 50 character ^[A-Z].*") String name, @NotEmpty(message = "List subjects not empty") List<SubjectDTO> subjects) {
        this.name = name;
        this.subjects = subjects;
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

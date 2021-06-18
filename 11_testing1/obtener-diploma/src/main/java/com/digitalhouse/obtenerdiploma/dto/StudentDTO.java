package com.digitalhouse.obtenerdiploma.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotNull( message="Name cannot be null")
    @Size(min = 5, max = 50, message = "Max size 50 character ")
    @Pattern(regexp = "^[A-Z][a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*$", message = "El nombre del alumno comenzar con mayúscula.")
    private String name;

    @NotEmpty(message = "List subjects not empty")
    private List<@Valid  SubjectDTO> subjects;

    public StudentDTO() {
    }

    public StudentDTO(
            @NotNull(message = "Name cannot be null")
            @Size(max = 50, message = "Max size 50 character ^[A-Z].*") String name, @NotEmpty(message = "List subjects not empty") List<SubjectDTO> subjects) {
        this.name = name;
        this.subjects = subjects;
    }



}

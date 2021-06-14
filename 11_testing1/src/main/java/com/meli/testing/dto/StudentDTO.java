package com.meli.testing.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDTO {

    @NotEmpty(message = "The studentName required")
    @Pattern(regexp = "[A-Z\\u00d1][a-zà-ÿ\\u00f1]*", message = "The studentName need start with a Capital Letter")
    @Size(max = 50, message = "StudentName soo Long, Max 50 characters")
    private String studentName;

    @NotEmpty(message = "The subjects required")
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

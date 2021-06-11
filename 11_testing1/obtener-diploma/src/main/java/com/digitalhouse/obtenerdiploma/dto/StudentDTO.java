package com.digitalhouse.obtenerdiploma.dto;

import java.util.List;

public class StudentDTO {
    private String studentName;
    private List<SubjectDTO> subjects;

    public StudentDTO() {
    }

    public StudentDTO(String name, List<SubjectDTO> subjects) {
        this.studentName = name;
        this.subjects = subjects;
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

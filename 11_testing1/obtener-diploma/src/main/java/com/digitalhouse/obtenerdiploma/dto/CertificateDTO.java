package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDTO extends StudentDTO {
    private String studentName;
    private String message;
    private Double averageScore;
    private List<SubjectDTO> subjects;

    public CertificateDTO(StudentDTO student) {
        this.studentName = student.getStudentName();
        this.subjects= student.getSubjects();
    }

    /*public CertificateDTO() {
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }*/
}

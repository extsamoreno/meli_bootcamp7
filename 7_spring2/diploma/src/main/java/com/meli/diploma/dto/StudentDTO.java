package com.meli.diploma.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDTO {

    private String name;
    private List<SubjectDTO> subjectsList;

    public float calculateAverage() {
        float totalGrades = 0;
        for (SubjectDTO subject : subjectsList) {
            totalGrades += subject.getGrade();
        }
        return totalGrades / subjectsList.size();
    }
}

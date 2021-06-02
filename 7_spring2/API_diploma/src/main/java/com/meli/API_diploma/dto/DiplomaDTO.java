package com.meli.API_diploma.dto;

import lombok.*;

@Setter
@Getter
public class DiplomaDTO {
    private String message = "IT BootCamp Java Diploma";
    private String nameStudent;
    private float averageCourses;
    private String congratulations;

    public DiplomaDTO(String nameStudent, float averageCourses) {
        this.nameStudent = nameStudent;
        this.averageCourses = averageCourses;
    }
}

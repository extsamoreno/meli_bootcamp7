package com.example.diploms.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class ScoreDTO extends StudentDTO{

    private String message;
    private double averageScore;

    public ScoreDTO(StudentDTO student , double averageScore){

        this.setStudentName(student.getStudentName());
        this.setSubjects(student.getSubjects());
        this.averageScore = averageScore;
        this.message = "El Alumno "+student.getStudentName()+" ha obtenido un promedio de "+averageScore;
    }
}

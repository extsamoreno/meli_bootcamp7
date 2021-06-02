package com.meli.spring2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentHistory {

    private String studentName;
    private List<Subject> grades;

    public double getAverage(){
        return grades.stream().mapToDouble(subject -> subject.getGrade()).sum()/grades.size();
    }

    public Degree getDegree(){

        Double average = getAverage();
        String message = "Felicitaciones por haber terminando el bootcamp";
        if (average > 9){
            message += " Tuviste un rendimiento sobresaliente";
        }
        return new Degree( this.studentName, message , average );
    }

}

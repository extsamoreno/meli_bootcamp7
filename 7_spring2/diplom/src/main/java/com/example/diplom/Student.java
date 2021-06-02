package com.example.diplom;

import java.util.List;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
public class Student {


    private String name;
    private List<Course> courses;


    public double calFinalGrade(){

        double output = 0.0;

        for (int i = 0; i < this.courses.size() ; i++) {
            output = output + this.courses.get(i).getGrade();
        }

        return output/ ((double) this.courses.size());
    }

    public Diplom genDiplom(){

        double finalGrade = this.calFinalGrade();
        String message = (finalGrade > 9.0) ? "Congratulations !!" : "";

        return new Diplom(this.name, finalGrade, message );
    }
}

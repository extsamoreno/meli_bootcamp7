package com.Spring.clase2.Services;

import com.Spring.clase2.Entities.Diploma;
import com.Spring.clase2.Entities.Student;
import com.Spring.clase2.Entities.Subject;

public class DiplomaService {

    public Diploma generateDiploma(Student student){
        Diploma diploma = new Diploma();
        diploma.setStudent(student.getName());

        double average = calculateAverage(student);
        diploma.setAverage(average);

        if(average > 9)
        {
            diploma.setMessage("Muchas Felicitaciones!!");
        }else{
            diploma.setMessage("Bien.");
        }

        return diploma;
    }

    private double calculateAverage(Student student){
        double auxNotes = 0;

        for (Subject s: student.getSubjects()) {
            auxNotes += s.getNote();
        }

        return auxNotes / student.getSubjects().size();
    }
}

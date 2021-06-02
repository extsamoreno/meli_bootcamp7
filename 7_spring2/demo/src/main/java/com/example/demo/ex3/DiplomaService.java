package com.example.demo.ex3;

import java.text.DecimalFormat;

public class DiplomaService {
    public Diploma generateDiploma(Student student) {
        Diploma diploma = new Diploma();
        double averageGrade = student.getSubjects().stream().mapToDouble(Subject::getQualification).sum();
        averageGrade /= student.getSubjects().size();
        student.setSubjects(null);
        diploma.setStudentName(student.getName() + " " + student.getLastname());
        if (averageGrade > 9) {
            diploma.setMessage("¡¡Felicitaciones!!");
        }
        DecimalFormat df = new DecimalFormat("#.##");
        averageGrade = Double.valueOf(df.format(averageGrade));
        diploma.setAverage(averageGrade);
        return diploma;
    }
}

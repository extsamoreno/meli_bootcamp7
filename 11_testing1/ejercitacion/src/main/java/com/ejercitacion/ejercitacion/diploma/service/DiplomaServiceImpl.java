package com.ejercitacion.ejercitacion.diploma.service;

import com.ejercitacion.ejercitacion.diploma.model.Student;
import com.ejercitacion.ejercitacion.diploma.model.Diploma;
import com.ejercitacion.ejercitacion.diploma.model.Subject;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class DiplomaServiceImpl {

    public Diploma generateDiploma(Student student) {
        Diploma diploma = new Diploma();
        double averageGrade = student.getSubjects().stream().mapToDouble(Subject::getGrade).sum();
        averageGrade /= student.getSubjects().size();
//        alumn.setSubjects(null);
        diploma.setAlumn(student);
        diploma.setMessage("El alumno " + student.getName() + " ha obtenido un promedio de " + averageGrade);
        DecimalFormat df = new DecimalFormat("#.##");
        averageGrade = Double.valueOf(df.format(averageGrade));
        diploma.setAverageGrade(averageGrade);
        return diploma;
    }


}

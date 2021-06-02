package com.ejercitacion.ejercitacion.diploma.service;

import com.ejercitacion.ejercitacion.diploma.model.Alumn;
import com.ejercitacion.ejercitacion.diploma.model.Diploma;
import com.ejercitacion.ejercitacion.diploma.model.Subject;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class DiplomaService {

    public Diploma generateDiploma(Alumn alumn) {
        Diploma diploma = new Diploma();
        double averageGrade = alumn.getSubjects().stream().mapToDouble(Subject::getGrade).sum();
        averageGrade /= alumn.getSubjects().size();
        alumn.setSubjects(null);
        diploma.setAlumn(alumn);
        if (averageGrade > 9) {
            diploma.setMensaje("Congratulations on your great grades!");
        }
        DecimalFormat df = new DecimalFormat("#.##");
        averageGrade = Double.valueOf(df.format(averageGrade));
        diploma.setAverageGrade(averageGrade);
        return diploma;
    }


}

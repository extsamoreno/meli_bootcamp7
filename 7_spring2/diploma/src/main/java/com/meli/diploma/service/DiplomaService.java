package com.meli.diploma.service;

import com.meli.diploma.domain.DiplomaDTO;
import com.meli.diploma.domain.Student;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {
    public DiplomaDTO getDiploma(Student student) {

        DiplomaDTO diploma = new DiplomaDTO();
        double average = student.calculateAverage();

        String finalMessage =
                average > 9 ?
                    "Felicitaciones por obtener un promedio superior a 9" :
                    "Felicitaciones por obtener tu diploma";

        diploma.setAverage(average);
        diploma.setStudent(student.getName());
        diploma.setMessage(finalMessage);

        return diploma;
    }
}

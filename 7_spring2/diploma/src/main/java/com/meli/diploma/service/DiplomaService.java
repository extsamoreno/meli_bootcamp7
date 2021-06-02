package com.meli.diploma.service;

import com.meli.diploma.domain.DiplomaDTO;
import com.meli.diploma.domain.Student;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {
    public DiplomaDTO getDiploma(Student student) {
        double average = student.calculateAverage();
        String msg = diplomaMessage(average);
        return new DiplomaDTO(student.getName(), average, msg);
    }

    private String diplomaMessage(double average) {
        if (average > 9) {
            return "Felicitaciones por obtener un promedio superior a 9";
        } else {
            return "Felicitaciones por obtener tu diploma";
        }
    }

}

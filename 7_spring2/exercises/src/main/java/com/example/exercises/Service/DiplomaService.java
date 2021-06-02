package com.example.exercises.Service;

import com.example.exercises.Models.DTO.DiplomaDTO;
import com.example.exercises.Models.Student;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {

    public DiplomaDTO getDiploma(Student student) {
        DiplomaDTO diploma = new DiplomaDTO();
        double average = student.calculateAverage();
        if (average > 9) {
            diploma.setMessage("Felicitaciones por obtener un promedio superior a 9");
        } else {
            diploma.setMessage("Felicitaciones por obtener tu diploma");
        }

        diploma.setAverage(average);
        diploma.setStudent(student.getName());

        return diploma;
    }
}

package com.ejercicio._spring2.ej3.service;

import com.ejercicio._spring2.ej3.dto.DiplomaDTO;
import com.ejercicio._spring2.ej3.dto.StudentDTO;
import com.ejercicio._spring2.ej3.dto.SubjectDTO;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DiplomaService implements IDiplomaService {

    public DiplomaDTO getDiploma(StudentDTO student) {
        DiplomaDTO diploma = new DiplomaDTO();
        double average = obtenerPromedio(student.getSubjects());
        String message = "muy bien";
        if (average > 9) {
            message =  "¡Felicitaciones " + student.getName() +
                    "! Usted tiene el gran promedio de " + average;
        } else if (average < 5) {
            message = "estudiar más";
        }
        diploma.setMessage(message);
        diploma.setScoreAverage(average);
        diploma.setStudentName(student);
        return diploma;
    }

    private double obtenerPromedio(List<SubjectDTO> subjectDTOList) {
        return subjectDTOList.stream()
                .mapToDouble(subject -> subject.getScore())
                .sum() / subjectDTOList.size();
    }

}

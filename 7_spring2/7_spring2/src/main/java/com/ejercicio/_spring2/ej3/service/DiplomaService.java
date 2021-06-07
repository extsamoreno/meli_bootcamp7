package com.ejercicio._spring2.ej3.service;



import com.ejercicio._spring2.ej3.dto.DiplomaDTO;
import com.ejercicio._spring2.ej3.dto.StudentDTO;
import com.ejercicio._spring2.ej3.dto.SubjectDTO;


import java.util.List;


public class DiplomaService {

    public DiplomaDTO obtenerDiploma(StudentDTO student) {
        DiplomaDTO diploma = new DiplomaDTO();
        double promedio = obtenerPromedio(student.getSubjectList());
        String message = "muy bien";
        if (promedio > 9) {
            message = "FELICITACIONES ! ";
        } else if (promedio < 5) {
            message = "estudiar más";
        }
        diploma.setMessage(message);
        diploma.setScoreAverage(promedio);
        diploma.setStudentName(student.getName());
        return diploma;
    }

    private double obtenerPromedio(List<SubjectDTO> subjectDTOList) {
        return subjectDTOList.stream()
                .mapToDouble(subject -> subject.getGrade())
                .sum() / subjectDTOList.size();
    }

}

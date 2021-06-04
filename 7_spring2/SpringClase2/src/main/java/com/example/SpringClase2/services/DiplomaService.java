package com.example.springclase2.services;

import com.example.springclase2.dto.*;
import java.util.HashMap;

public class DiplomaService {

    public static Double calculateAverage(HashMap<String, Integer> subjects)
    {
        Double sum = 0d;
        for (Integer qualif: subjects.values()) {
            sum += qualif;
        }
        return sum / subjects.size();
    }

    public static DiplomaDTO buildDiploma(Student student)
    {
        Double average = calculateAverage(student.getSubjects());
        String message = "Sigue esforzándote. ¡Ánimo!";

        DiplomaDTO diplomaDTO = new DiplomaDTO();
        diplomaDTO.setStudentName(student.getName());
        diplomaDTO.setAverage(average);

        if (average > 9)
        {
            message = "¡¡¡Felicitaciones!!!";
        }
        else if (average >=4)
        {
            message = "¡Bien! Has aprobado.";
        }
        diplomaDTO.setMessage(message);

        return diplomaDTO;
    }
}

package com.meli.diploma.service;

import com.meli.diploma.dto.DiplomaDTO;
import com.meli.diploma.dto.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class DiplomaServiceImp implements IDiplomaService {

    @Override
    public DiplomaDTO getDiplomaStudent(StudentDTO student) {

        DiplomaDTO diploma = new DiplomaDTO();
        String message = "Congratulations.";
        float average = student.calculateAverage();

        if (average > 9) {
            message.concat(" Your average is higher than 9");
        }

        diploma.setStudent(student.getName());
        diploma.setAverage(average);
        diploma.setMessage(message);

        return diploma;
    }
}

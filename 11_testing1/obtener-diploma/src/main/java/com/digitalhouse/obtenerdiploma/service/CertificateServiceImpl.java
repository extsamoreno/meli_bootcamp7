package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {
    public CertificateDTO analyzeNotes(StudentDTO notes) {
        CertificateDTO response = new CertificateDTO();
        response.setStudentName(notes.getStudentName());
        response.setAverageScore(calculateAverage(notes));
        response.setMessage(writeDiploma(notes));
        response.setSubjects(notes.getSubjects());
        return response;
    }

    private Double calculateAverage(StudentDTO notes) {
        int sum = notes.getSubjects().stream().mapToInt(SubjectDTO::getScore).sum();
        return round(sum / (double) notes.getSubjects().size(), 2);
    }

    private String writeDiploma(StudentDTO notes) {
        Double localAverage = calculateAverage(notes);
        String studentName = notes.getStudentName();
        String message = studentName + " usted ha conseguido el promedio de " + localAverage;
        if (localAverage > 9)
            message = withHonors(localAverage, studentName);
        return message;
    }

    private String withHonors(Double localAverage, String localStudent) {
        return "¡Felicitaciones " + localStudent + "! Usted tiene el gran promedio de " + localAverage;
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}

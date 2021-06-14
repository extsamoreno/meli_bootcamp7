package com.meli.testing.service;

import com.meli.testing.dto.StudentDTO;
import com.meli.testing.dto.CertificateDTO;
import com.meli.testing.dto.SubjectDTO;
import org.springframework.stereotype.Service;


@Service
public class CertificateServiceImpl implements CertificateService {

  public CertificateDTO analyzeNotes(StudentDTO notes) {
    CertificateDTO response = new CertificateDTO();

    response.setStudentName(notes.getStudentName());
    response.setMessage(writeDiploma(notes));
    response.setAverageScore(transform2Digit(calculateAverage(notes)));
    response.setSubjects(notes.getSubjects());

    return response;
  }

  private Double calculateAverage(StudentDTO notes) {
    int sum = notes.getSubjects().stream()
            .mapToInt(SubjectDTO::getScore)
            .sum();

    return sum / (double) notes.getSubjects().size();
  }

  private String writeDiploma(StudentDTO notes) {
    Double localAverage = transform2Digit( calculateAverage(notes) );
    String studentName = notes.getStudentName();
    String message = studentName + " usted ha conseguido el promedio de " + localAverage;
    if(localAverage > 9)
      message = withHonors(localAverage, studentName);
    return message;
  }

  private String withHonors(Double localAverage, String localStudent) {
    return "¡Felicitaciones " + localStudent + "! Usted tiene el gran promedio de " + localAverage;
  }

  private Double transform2Digit(Double response){
    return Math.round(response*100.0)/100.0;
  }
}

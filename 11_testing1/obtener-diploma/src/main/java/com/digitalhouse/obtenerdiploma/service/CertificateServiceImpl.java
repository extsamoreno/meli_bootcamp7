package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {
  public CertificateDTO analyzeNotes(StudentDTO notes) {

    CertificateDTO response = new CertificateDTO(notes);

    response.setAverageScore(calculateAverage(response.getSubjects()));

    response.setMessage(writeDiploma(notes));
    return response;
  }

  private Double calculateAverage(List<SubjectDTO> notes) {
    Double sum = notes.stream().mapToDouble(SubjectDTO::getScore).sum();
    return sum / (double) notes.size();
  }

  private String writeDiploma(StudentDTO notes) {
    Double localAverage = calculateAverage(notes.getSubjects());
    String studentName = notes.getStudentName();
    String message = studentName + " usted ha conseguido el promedio de " + localAverage;
    if(localAverage > 9)
      message = withHonors(localAverage, studentName);
    return message;
  }

  private String withHonors(Double localAverage, String localStudent) {
    return "¡Felicitaciones " + localStudent + "! Usted tiene el gran promedio de " + localAverage;
  }
}

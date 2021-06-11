package com.example.diploma.service;


import com.example.diploma.dto.CertificateDTO;
import com.example.diploma.dto.StudentDTO;
import com.example.diploma.dto.SubjectDTO;
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
    double average = sum / (double) notes.getSubjects().size();

    return Math.round(average*100.0)/100.0;
  }

  private String writeDiploma(StudentDTO notes) {
    Double localAverage = calculateAverage(notes);
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

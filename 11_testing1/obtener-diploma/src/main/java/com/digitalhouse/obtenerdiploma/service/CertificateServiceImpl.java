package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.Exception.LowAverageException;
import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {

  public CertificateDTO analyzeNotes(StudentDTO studentDTO) throws LowAverageException {
    CertificateDTO response = new CertificateDTO();
    response.setStudent(studentDTO);
    response.setAverage(calculateAverage(studentDTO));
    response.setMessage(writeDiploma(studentDTO));
    return response;
  }

  private double calculateAverage(StudentDTO notes) {
    double sum = notes.getSubjects().stream().mapToDouble(SubjectDTO::getScore).sum();
    double average = sum / notes.getSubjects().size();
    return Math.round(average*100.0)/100.0;
  }

  private String writeDiploma(StudentDTO notes) throws LowAverageException {
    double localAverage = calculateAverage(notes);
    String studentName = notes.getStudentName();
    String message = studentName + " usted ha conseguido el promedio de " + localAverage;
    if(localAverage > 9)
      message = withHonors(localAverage, studentName);
    else if(localAverage < 6.5)
      throw new LowAverageException(localAverage);
    return message;
  }

  private String withHonors(double localAverage, String localStudent) {
    return "¡Felicitaciones " + localStudent + "! Usted tiene el gran promedio de " + localAverage;
  }
}

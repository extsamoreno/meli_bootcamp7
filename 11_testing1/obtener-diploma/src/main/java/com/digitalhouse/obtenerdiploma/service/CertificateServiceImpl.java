package com.digitalhouse.obtenerdiploma.service;


import com.digitalhouse.obtenerdiploma.service.dto.*;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {

  @Override
  public CertificateDTO analyzeNotes(StudentDTO notes) {
    CertificateDTO response = new CertificateDTO(notes);
    response.setAverage(calculateAverage(notes));
    response.setMessage(writeDiploma(notes));
    return response;
  }

  @Override
  public AverageNotesDTO averageNotes(StudentNameDTO notes) {
    AverageNotesDTO result = new AverageNotesDTO();
    result.setStudentName(notes.getName());
    result.setSubjects(notes.getSubjects());
    Double localAverage = calculateAverage(notes);;
    result.setAverageScore(localAverage);
    result.setMessage(writeDiploma(localAverage,notes.getName()));
    return result;
  }

  private Double calculateAverage(StudentDTO notes) {
    double sum = notes.getSubjects().stream().mapToDouble(SubjectDTO::getScore).sum();
    return sum / (double) notes.getSubjects().size();
  }

  private String writeDiploma(StudentDTO notes) {
    Double localAverage = calculateAverage(notes);
    String studentName = notes.getName();
    String message = studentName + " usted ha conseguido el promedio de " + localAverage;
    if(localAverage > 9)
      message = withHonors(localAverage, studentName);
    return message;
  }

  private String writeDiploma(double localAverage,String studentName) {

    String message = studentName + " usted ha conseguido el promedio de " + localAverage;
    if(localAverage > 9)
      message = withHonors(localAverage, studentName);
    return message;
  }


  private String withHonors(Double localAverage, String localStudent) {
    return "¡Felicitaciones " + localStudent + "! Usted tiene el gran promedio de " + localAverage;
  }



}

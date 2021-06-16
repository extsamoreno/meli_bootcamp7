package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.exception.NotValidResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {
  public CertificateDTO analyzeNotes(StudentDTO notes) throws NotValidResponseException {
    CertificateDTO response = new CertificateDTO(notes);
    double average = calculateAverage(notes);
    if(average < 0){
      throw new NotValidResponseException("Average value cannot be less than 0.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    notes.setName("");
    if(notes.getName()==null){
      throw new NotValidResponseException("Name cannot be null", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    if(notes.getName().isEmpty()){
      throw new NotValidResponseException("Name cannot be Empty", HttpStatus.INTERNAL_SERVER_ERROR);
    }


      response.setAverage(average);
      response.setMessage(writeDiploma(notes));
      return response;



  }

  private Double calculateAverage(StudentDTO notes) {
    int sum = notes.getSubjects().stream().mapToInt(SubjectDTO::getNote).sum();
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

  private String withHonors(Double localAverage, String localStudent) {
    return "¡Felicitaciones " + localStudent + "! Usted tiene el gran promedio de " + localAverage;
  }
}

package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.Repository.ISubjectRepository;
import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.exceptions.SubjectException;
import com.digitalhouse.obtenerdiploma.exceptions.SubjectNameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService{

  @Autowired
  ISubjectRepository iSubjectRepository;

  public CertificateDTO analyzeNotes(StudentDTO notes) throws SubjectNameNotFoundException {
    for(SubjectDTO subjectDTO: notes.getSubjects()){
      if(iSubjectRepository.getSubjectByname(subjectDTO.getSubject()) == null) throw new SubjectNameNotFoundException(subjectDTO.getSubject());
    }
    CertificateDTO response = new CertificateDTO(notes);
    response.setAverage(calculateAverage(notes));
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

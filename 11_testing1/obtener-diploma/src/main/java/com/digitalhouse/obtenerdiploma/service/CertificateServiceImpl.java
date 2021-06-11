package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.exception.DuplicateSubjectNameException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {
  public CertificateDTO analyzeNotes(StudentDTO notes) throws Exception{
    List<SubjectDTO> subjects= notes.getSubjects();
    for (int i = 0; i < subjects.size(); i++) {
      for (int j = 0; j < subjects.size(); j++) {
        if (j != i) {
          if (subjects.get(i).getName().equals(subjects.get(j).getName())) throw new DuplicateSubjectNameException();
        }
      }
    }
    CertificateDTO response = new CertificateDTO();
    response.setStudentName(notes.getStudentName());
    response.setSubjets(notes.getSubjects());
    response.setAverage(calculateAverage(notes));
    response.setMessage(writeDiploma(notes));
    return response;
  }

  private Double calculateAverage(StudentDTO notes) {
    Double sum = notes.getSubjects().stream().mapToDouble(SubjectDTO::getScore).sum();
    return sum / (double) notes.getSubjects().size();
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

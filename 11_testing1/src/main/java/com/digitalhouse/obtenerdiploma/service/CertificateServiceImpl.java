package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentNotesResponseDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {

  public CertificateDTO analyzeNotes(StudentDTO studentDTO) {

    CertificateDTO response = new CertificateDTO(studentDTO);

    response.setStudentName(studentDTO.getStudentName());
    response.setAverage(calculateAverage(studentDTO));
    response.setMessage(writeDiploma(studentDTO));

    return response;
  }

  @Override
  public StudentNotesResponseDTO obtainAverageNotes(StudentDTO studentDTO) {
    StudentNotesResponseDTO responseDTO = new StudentNotesResponseDTO();

    responseDTO.setStudentName(studentDTO.getStudentName());
    responseDTO.setAverageScore(calculateAverage(studentDTO));
    responseDTO.setMessage(writeDiploma(studentDTO));
    responseDTO.setSubjects(studentDTO.getSubjects());

    return responseDTO;
  }

  private Double calculateAverage(StudentDTO notes) {
    int sum = notes.getSubjects().stream().mapToInt(SubjectDTO::getScore).sum();
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

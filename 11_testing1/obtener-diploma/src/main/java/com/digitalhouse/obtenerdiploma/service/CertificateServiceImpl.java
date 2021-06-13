package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.exception.ValidationOutputException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class CertificateServiceImpl implements CertificateService {

  public CertificateDTO analyzeNotes(StudentDTO notes) throws ValidationOutputException {
    CertificateDTO response = new CertificateDTO();
    response.setStudentName(notes.getStudentName());
    response.setStudentName(notes.getStudentName());
    response.setAverageScore(calculateAverage(notes));
    response.setMessage(writeDiploma(notes));
    response.setSubjects(notes.getSubjects());
    testEmpty(response);
    return response;
  }

  private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


  public void testEmpty(CertificateDTO certificateDTO) throws ValidationOutputException {
    Set<ConstraintViolation<CertificateDTO>> violations = validator.validate(certificateDTO);

    if(violations.size() > 0){
      Map<String, String> errors = new HashMap<>();

      violations.forEach(v -> errors.put(v.getPropertyPath().toString(), v.getMessage()));
      //v.getMessageTemplate() igual que getMessage
      throw new ValidationOutputException(errors);
    }
  }


  private Double calculateAverage(StudentDTO notes) {
    double sum = notes.getSubjects().stream().mapToDouble(SubjectDTO::getScore).sum();
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

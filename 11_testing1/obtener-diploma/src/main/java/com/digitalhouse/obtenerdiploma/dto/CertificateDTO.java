package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class CertificateDTO extends StudentDTO {
  @Pattern(regexp="^[A-Z].*",message="El nombre del alumno debe comenzar con mayúscula")
  @NotEmpty(message = "El nombre de alumno no puede estar vacio")
  @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
  private String studentName;

  @NotEmpty (message = "La lista de materias no puede estar vacia")
  private List<@Valid SubjectDTO> subjects;

  @NotEmpty (message = "El mensaje no puede ser vacio")
  private String message;

  @NotNull(message = "El promedio no puede estar vacío")
  @Max(value = 10 , message = "El promedio debe ser menor a 10")
  @Min(value = 0 , message = "EL promedio debe ser mayor a 0")
  private Double average;


  public CertificateDTO() { }

  @Override
  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public List<SubjectDTO> getSubjects() {
    return subjects;
  }

  public void setSubjets(List<SubjectDTO> subjects) {
    this.subjects = subjects;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Double getAverage() {
    return average;
  }

  public void setAverage(Double average) {
    this.average = average;
  }

}

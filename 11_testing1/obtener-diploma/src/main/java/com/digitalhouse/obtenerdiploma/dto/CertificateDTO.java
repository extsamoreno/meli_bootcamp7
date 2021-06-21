package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CertificateDTO extends StudentDTO {
  @NotNull(message = "El mensaje no puede estar vacío.")
  private String message;
  @NotNull(message = "El promedio no puede estar vacío.")
  @Min(value = 0,message = "El promedio es 0.0")
  @Max(value = 10,message = "El promedio es 10.0")
  private Double average;
  private StudentDTO student;

  public CertificateDTO() {
  }

  public CertificateDTO(StudentDTO student) {
    this.student = student;
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

  public StudentDTO getStudent() {
    return student;
  }

  public void setStudent(StudentDTO student) {
    this.student = student;
  }
}

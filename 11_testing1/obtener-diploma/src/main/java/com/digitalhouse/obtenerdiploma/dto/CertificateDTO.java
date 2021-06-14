package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CertificateDTO extends StudentDTO {
  @NotBlank(message = "El mensaje de certificado no puede ser vacio")
  private String message;
  @Max(value = 10, message = "El promedio maximo es 10")
  @Min(value = 0, message = "El promedio minimo es 0")
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

package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class CertificateDTO extends StudentDTO {

  @NotNull(message = "El nombre no puede estar vacía")
  private String message;

  @NotNull(message = "El promedio no puede estar vacía")
  @Min(value = 0, message = "El minimo promedio es 0.0.")
  @Max(value = 10, message = "El maximo promedio es 10.0.")
  private Double average;

  @Valid
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

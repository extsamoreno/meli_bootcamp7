package com.digitalhouse.obtenerdiploma.dto;

public class CertificateDTO extends StudentDTO {
  private String message;
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

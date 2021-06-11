package com.digitalhouse.obtenerdiploma.dto;

import java.util.List;

public class CertificateDTO extends StudentDTO {
  private String studentName;
  private String message;
  private Double averageScore;
  private List<SubjectDTO> subjects;

  public CertificateDTO() {
  }

  @Override
  public String getStudentName() {
    return studentName;
  }

  @Override
  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Double getAverageScore() {
    return averageScore;
  }

  public void setAverageScore(Double averageScore) {
    this.averageScore = averageScore;
  }

  @Override
  public List<SubjectDTO> getSubjects() {
    return subjects;
  }

  @Override
  public void setSubjects(List<SubjectDTO> subjects) {
    this.subjects = subjects;
  }
}

package com.example.diploma.dto;

import java.util.List;

public class CertificateDTO extends StudentDTO {
  private String studentName;
  private String message;
  private Double averageScore;
  private List<SubjectDTO> subjects;

  public CertificateDTO() {
  }


  public String getStudentName() {
    return studentName;
  }

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

  public void setAverageScore(Double average) {
    this.averageScore = average;
  }

  public List<SubjectDTO> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<SubjectDTO> subjects) {
    this.subjects = subjects;
  }
}

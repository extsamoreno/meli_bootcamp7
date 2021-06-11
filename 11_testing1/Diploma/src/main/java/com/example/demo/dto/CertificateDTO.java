package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class CertificateDTO  {
  private String studentName;
  private String message;
  private Double average;
  private StudentDTO student;

  public CertificateDTO(StudentDTO student) {
    this.student = student;
  }


}

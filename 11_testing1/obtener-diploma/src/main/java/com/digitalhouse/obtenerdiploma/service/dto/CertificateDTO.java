package com.digitalhouse.obtenerdiploma.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDTO extends StudentDTO {
  private String message;
  private Double average;
  private StudentDTO student;


  public CertificateDTO(StudentDTO student) {

    this.student = student;
  }
}

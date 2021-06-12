package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CertificateDTO extends StudentDTO {
  private String studentName;
  private Double average;
  private String message;
  private List<SubjectDTO> subjects;

  public CertificateDTO() {
    this.subjects = new ArrayList<>();
  }
}
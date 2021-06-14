package com.meli.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDTO{

  private String studentName;
  private String message;
  private Double averageScore;
  private List<SubjectDTO> subjects;

}

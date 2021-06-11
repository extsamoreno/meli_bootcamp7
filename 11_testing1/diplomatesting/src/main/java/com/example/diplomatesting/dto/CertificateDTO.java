package com.example.diplomatesting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDTO extends StudentDTO {
  private String studentName;
  private String message;
  private Double averageScore;
  private List<SubjectDTO> subjects;

}

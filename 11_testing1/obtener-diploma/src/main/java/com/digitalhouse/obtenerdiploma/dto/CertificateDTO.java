package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDTO extends StudentDTO {
  private String studentName;
  private Double average;
  private String message;
  private List<SubjectDTO> subjects;

}

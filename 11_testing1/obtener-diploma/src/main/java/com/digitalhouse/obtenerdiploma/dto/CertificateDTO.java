package com.digitalhouse.obtenerdiploma.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDTO {
  private String message;
  private float average;
  private StudentDTO student;

}

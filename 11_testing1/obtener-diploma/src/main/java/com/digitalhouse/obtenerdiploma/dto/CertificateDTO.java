package com.digitalhouse.obtenerdiploma.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDTO extends StudentDTO{
  private String message;
  private double average;
  private StudentDTO student;

}

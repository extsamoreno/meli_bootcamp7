package com.digitalhouse.obtenerdiploma.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@JsonPropertyOrder({ "studentName", "message", "average", "subjects" })
public class CertificateDTO extends StudentDTO{
  private String message;
  private double average;

}

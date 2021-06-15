package com.digitalhouse.obtenerdiploma.dto;

public class CertificateDTO extends StudentDTO {
  private String message;
  private Double average;


  public CertificateDTO() {
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Double getAverage() {
    return average;
  }

  public void setAverage(Double average) {
    this.average = average;
  }

}

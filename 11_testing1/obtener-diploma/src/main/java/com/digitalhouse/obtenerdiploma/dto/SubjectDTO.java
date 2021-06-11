package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.constraints.*;

public class SubjectDTO {

  @NotEmpty(message = "El nombre de la materia no puede estar vacío")
  @Size(max=30, message = "La longitud del nombre no puede superar los 30 caracteres")
  @Pattern(regexp = "[A-Z](([a-z]|[á-ú]|é)*(\\s)?)([A-Z]?(([a-z]|[á-ú]|é)*(\\s)?)+)*[0-9]?",
          message = "El nombre de la materia debe comenzar con mayúscula y luego minúsculas.")
  private String subject;

  @NotNull(message = "La nota no puede estar vacía.")
  @DecimalMin(value = "0.0", message = "La mínima nota es 0.0")
  @DecimalMax(value = "10.0", message = "La máxima nota es 10.0")
  private double note;

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Double getNote() {
    return note;
  }

  public void setNote(Double note) {
    this.note = note;
  }

}

package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Valid
public class SubjectDTO {
  @NotEmpty(message = "El nombre de la materia no puede estar vacio")
  @Pattern(regexp = "^[A-Z]{1}.[^A-Z]*$", message = "El nombre de la materia debe comenzar con mayúscula y el resto en minúscula")
  @Size(min = 1, max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
  private String subject;
  @NotNull(message = "La nota no puede estar vacia")
  @Min(value = 0, message = "La mínima nota es 0.0")
  @Max(value = 10,message = "La máxima nota es 10.0")
  private Double note;

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

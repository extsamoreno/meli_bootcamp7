package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.constraints.*;

public class SubjectDTO {
  @NotNull(message = "El nombre de la materia no puede estar vacío")
  @Pattern(regexp = "^[A-Z].*$", message = "El nombre de la materia debe comenzar con mayúscula.")
  @Size(max=30,message = "La longitud del nombre no puede superar los 30 caracteres")
  private String subject;
  @NotNull(message = "La nota no puede estar vacía.")
  //@Min(value = 0,message = "La mínima nota es 0.0")
  @Max(value = 10,message = "La máxima nota es 10.0")
  private Integer note;
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Integer getNote() {
    return note;
  }

  public void setNote(Integer note) {
    this.note = note;
  }

}

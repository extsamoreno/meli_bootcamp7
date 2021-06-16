package com.digitalhouse.obtenerdiploma.dto;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class SubjectDTO {
  @Valid
  @NotNull(message = "El nombre de la materia no puede ser nulo")
  @NotEmpty(message = "El nombre de la materia no puede estar vacío")
  @Pattern(regexp = "^[A-Z].*$", message ="El nombre de la materia debe comenzar con mayúscula")
  @Size(max = 30, message = "La longitud del nombre no puede superar 30 caracteres")
  private String subject;
  @Valid
  @Min(value = 0,message = "La mínima nota es 0")
  @Max(value = 10,message = "La máxima nota es 10")
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

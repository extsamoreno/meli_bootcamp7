package com.digitalhouse.obtenerdiploma.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class SubjectDTO {
  @NotNull
  @NotEmpty
  @Length(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
  @Pattern(message = "El nombre de la materia debe comenzar con mayúscula.",regexp = "^[A-Z].*")
  private String subject;

  @NotNull
  @Max(10)@Min(0)
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

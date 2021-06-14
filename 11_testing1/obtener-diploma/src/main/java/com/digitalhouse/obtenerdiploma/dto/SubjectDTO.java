package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.constraints.*;

public class SubjectDTO {
  @NotNull(message = "El nombre de la materia no puede ir vacio" )
  @Pattern(regexp = "^[A-Z].*$", message = "El nombre la materia debe comenzar con mayuscula")
  @Size(max = 30,message = "la longitud del nombre de la materia debe ser menor a 50" )
  private String subject;

  @NotNull(message = "El campo nota no puede ir vacio")
  @Min(value = 0, message = "La nota tiene que ser mayor que 0")
  @Max(value = 10, message = "La nota tiene que ser menor que 10")
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

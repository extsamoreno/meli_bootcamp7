package com.digitalhouse.obtenerdiploma.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@Valid
public class SubjectDTO {

  @NotNull
  @Size(min = 1, max = 30, message = "El nombre de la materia debe tener 30 caracteres maximo")
  @Pattern(message = "El nombre de la materia debe comenzar con mayuscula", regexp = "^[A-Z].*[a-z]$")

  private String subject;


  @NotNull
  @Max(value = 10, message = "La nota maxima es 10")
  @Min(value = 0, message = "La nota maxima es 10")
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

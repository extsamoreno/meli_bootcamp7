package com.validacionesyexcepciones.validacionesyexcepciones.dto;
import javax.validation.constraints.*;

public class SubjectDTO {
  @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
  @Size(max = 30,message = "La longitud del nombre no puede superar los 50 caracteres.")
  @Pattern(regexp = "[A-Z\\u00d1][a-zà-ÿ\\u00f1]*",message = "El nombre de la materia comenzar con mayúscula.")
  private String subject;
  @NotNull(message = "La nota no puede estar vacia")
  @Min(value = 0,message = "La minima nota es 0")
  @Max(value = 10,message = "La maxima nota es 10")
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

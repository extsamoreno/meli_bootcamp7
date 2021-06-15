package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.constraints.*;

public class SubjectDTO {

  @NotNull(message = "El nombre de la materia no puede estar vacío.")
  @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
  @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
  private String subjectName;

  @NotNull(message = "La nota no puede estar vacía.") @Min(value = 0, message = "La mínima nota es 0.0.") @Max(value = 10 - 0, message = "La máxima nota es 10.0.")
  private Integer note;

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public @NotNull(message = "La nota no puede estar vacía.") @Min(value = 0, message = "La mínima nota es 0.0.") @Max(value = 10 - 0, message = "La máxima nota es 10.0.") Integer getNote() {
    return note;
  }

  public void setNote(@NotNull(message = "La nota no puede estar vacía.") @Min(value = 0, message = "La mínima nota es 0.0.") @Max(value = 10 - 0, message = "La máxima nota es 10.0.") Integer note) {
    this.note = note;
  }

}

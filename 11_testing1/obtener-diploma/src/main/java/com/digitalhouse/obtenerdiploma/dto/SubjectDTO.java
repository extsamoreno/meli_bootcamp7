package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.constraints.*;

public class SubjectDTO {

  @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
  @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
  @Pattern(regexp = "[A-Z][a-z]*", message = "El nombre de la materia comenzar con mayúscula.")
  private String name;

  @NotNull(message = "La nota no puede estar vacía.")
  @Min(value = 0, message = "La mínima nota es 0.0")
  @Max(value = 10, message = "La máxima nota es 10.0")
  private double score;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

}

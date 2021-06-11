package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.constraints.*;

public class SubjectDTO {

  @NotNull(message = "name es un campo obligatorio")
  @NotEmpty(message = "El nombre de la materia no puede estar vacío")
  @Pattern(regexp = "\\b([A-Z])(\\S*?)\\b", message = "El nombre de la materia debe comenzar con mayúscula")
  @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
  private String name;

  @NotNull(message = "Nota es un campo obligatorio")
  @DecimalMax(value = "10.0", message = "La máxima nota es 10.0")
  @DecimalMin(value = "0.0", message = "La mínima nota es 0.0")
  private Integer score;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

}

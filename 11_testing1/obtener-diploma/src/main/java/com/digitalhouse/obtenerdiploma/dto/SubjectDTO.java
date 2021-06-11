package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.constraints.*;

public class SubjectDTO {

  @NotEmpty(message = "El nombre de la materia no puede estar vacío")
  @Pattern(regexp="^[A-Z].*",message="El nombre de la materia debe comenzar con mayúscula")
  @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
  private String name;
  @NotNull(message = "La nota no puede estar vacía")
  @Max(value = 10 , message = "La máxima nota es 10.0")
  @Min(value = 0 , message = "La mínima nota es 0.0")
  private Double score;

  public String getName() {
    return name;
  }

  public void setSubject(String name) {
    this.name = name;
  }

  public Double getScore() {
    return score;
  }

  public void setScore(Double score) { this.score = score;}

}

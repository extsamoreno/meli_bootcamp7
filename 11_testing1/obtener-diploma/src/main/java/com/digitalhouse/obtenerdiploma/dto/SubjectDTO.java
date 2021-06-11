package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectDTO {
  @NotBlank(message = "El nombre de la materia no puede estar vacio")
  @Pattern(regexp = "^[A-Z]([A-Za-z])*", message = "El nombre de la materia debe comenzar con mayuscula")
  @Size(max = 30,message = "La longitud del nombre no puede superar los 30 caracteres")
  private String name;
  @NotNull(message = "La nota no puede estar vacia")
  @Min(value = 0, message = "La minima nota es 0")
  @Max(value = 10,message = "La maxima nota es 10")
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

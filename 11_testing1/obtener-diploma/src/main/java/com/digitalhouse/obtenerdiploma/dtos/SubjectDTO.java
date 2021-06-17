package com.digitalhouse.obtenerdiploma.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
  @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
  @Size(max=30, message = "La longitud del nombre no puede superar los 30 caracteres.")
  @Pattern(regexp = "[A-Z\\u00d1][a-zà-ÿ\\u00f1]*", message = "El nombre de la materia debe comenzar con mayúscula.")
  private String name;

  @NotNull(message = "La nota no puede estar vacía.")
  @Min(value= 0, message = "La mínima nota es 0.0.")
  @Max(value= 10, message = "La máxima nota es 10.0.")
  private double score;
}

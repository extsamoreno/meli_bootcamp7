package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

  @NotBlank(message = "El nombre de la materia no puede estar vacío.")
  @Pattern(regexp="^[A-Z].*",message="El nombre de la materia debe comenzar con mayúscula")
  @Size(max = 30, message = "LLa longitud del nombre no puede superar los 30 caracteres.")
  private String name;

  @NotNull(message = "La nota no puede estar vacía.")
  @Max(value = 10, message = "La máxima nota es 10.")
  @Min(value = 0, message = "La nota minima es 0.")
  private int score;

}

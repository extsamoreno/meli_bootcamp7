package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class SubjectDTO {

  @NotBlank(message = "El nombre de la materia no puede estar vacío.")
  @NotNull(message = "El nombre de la materia no puede estar vacío.")
  @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
  @Pattern(regexp = "^.*[A-Z][a-z0-9_-áéíóú]{3,19}.*$", message = "El nombre de la materia debe comenzar con mayúscula.")
  private String name;

  @NotNull(message = "La nota no puede estar vacía.")
  @Min(value = 0, message = "La nota minima es 0.")
  @Max(value = 10, message = "La nota maxima es 10.")
  private Integer score;
}

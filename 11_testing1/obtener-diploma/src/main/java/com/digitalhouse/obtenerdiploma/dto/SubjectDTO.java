package com.digitalhouse.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

  @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
  @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
  @Size(max = 30, message = "La longitud del nombre de la materia no puede superar los 30 caracteres.")
  private String subject;

  @NotNull(message = "La nota no puede estar vacia.")
  @DecimalMin(value = "0.0", message = "La nota no puede ser menor a 0.0")
  @DecimalMax(value = "10.0", message = "La nota no puede ser mayor a 10.0")
  private double note;

}

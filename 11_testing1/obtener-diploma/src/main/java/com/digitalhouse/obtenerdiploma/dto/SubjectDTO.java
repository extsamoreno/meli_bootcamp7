package com.digitalhouse.obtenerdiploma.dto;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {

  @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
  @Size(min = 1, max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
  @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
  private String name;

  @NotNull(message = "La nota no puede estar vacía.")
  @Min(value = 0, message = "La nota debe ser mayor a 0")
  @Max(value = 10, message = "La nota debe ser menor a 10")
  private Double score;



}

package com.meli.tucasita.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EnvironmentDto {

  @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
  @Pattern(regexp = "^[A-Z].*", message = "El nombre del ambiente debe comenzar con mayúscula.")
  @Size(max = 30, message = "La longitud del nombre del ambiente no puede superar los 30 caracteres.")
  private String name;

  @NotNull(message = "El ancho del ambiente no puede estar vacío.")
  @Max(value = (long)25.0, message = "La máximo ancho permitido por ambiente es de 25 mts")
  private Double width;

  @NotNull(message = "El largo del ambiente no puede estar vacío.")
  @Max(value = (long)25.0, message = "La máximo largo permitido por ambiente es de 33 mts")
  private Double length;
}

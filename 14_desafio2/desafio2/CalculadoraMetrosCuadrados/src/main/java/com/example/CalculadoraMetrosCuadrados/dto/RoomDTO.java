package com.example.CalculadoraMetrosCuadrados.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class RoomDTO {

  @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
  @Pattern(regexp="^([A-Z].*)$|^$", message = "El nombre del ambiente debe comenzar con mayúscula.")
  @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
  private String roomName;

  @NotNull(message = "El ancho del ambiente no puede estar vacío.")
  @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts.")
  private Integer roomWidth;

  @NotNull(message = "El largo del ambiente no puede estar vacío.")
  @Max(value = 33, message = "El máximo largo permitido por propiedad es de 33 mts.")
  private Integer roomLength;
}

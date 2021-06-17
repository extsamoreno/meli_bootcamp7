package com.meli.tucasita.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DistrictDto {

  @NotNull
  private int id;

  @NotBlank(message = "El nombre del barrio no puede estar vacío.")
  @Size(max = 45, message = "La longitud del nombre del barrio no puede superar los 45 caracteres.")
  private String name;

  @NotNull
  @Max(value = (long)4000.0, message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S")
  private Double price;
}

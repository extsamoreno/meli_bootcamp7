package com.example.CalculadoraMetrosCuadrados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
public class HouseDTO {

  @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
  @Pattern(regexp="^([A-Z].*)$|^$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
  @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
  private String propName;

  private List<@Valid RoomDTO> rooms;

  @NotBlank(message = "El barrio no puede estar vacio.")
  @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
  private String districtName;

  @NotNull(message = "El precio de un barrio no puede estar vacio.")
  @Max(value = 4000, message = "El precio maximo permitido por metro cuadrado no puede superar los 4000 U$S.")
  private Double districtPrice;

}

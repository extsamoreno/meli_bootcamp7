package com.meli.tucasita.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PropertyDto {

  @NotNull
  private int id;

  @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
  @Pattern(regexp = "^[A-Z].*", message = "El nombre de la propiedad debe comenzar con mayúscula.")
  @Size(max = 30, message = "La longitud del nombre de la propiedad no puede superar los 30 caracteres.")
  String name;

  @NotNull
  private int districtId;
  private ArrayList<@Valid EnvironmentDto> environments;
}

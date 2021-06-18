package com.desafio2.testing.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequestDTO {

    @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del ambiente debe comenzar con mayúscula.")
    private String enviroment_name;

    @NotNull(message = "El ancho del ambiente no puede estar vacio")
    @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts")
   private double enviroment_width;


    @NotNull(message = "El largo del ambiente no puede estar vacio")
    @Max(value = 33, message = "El largo máximo permitido por propiedad es de 33 mts")
    private double enviroment_length;

}

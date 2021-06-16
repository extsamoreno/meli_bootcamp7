package com.tucasitatasaciones.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {

    @Valid
    @Min(value = 1, message = "El id de barrio debe ser mayor a 0.")
    @JsonProperty("district_id")
    private int id;

    @Valid
    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @NotNull(message = "El nombre de la propiedad no puede ser nulo.")
    @Size(min = 1, message = "La longitud del nombre debe ser al menos 1 caracter.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 45 caracteres.")
    @JsonProperty("district_name")
    private String name;

    @Valid
    @NotNull(message = "El precio de un barrio no puede estar vacío.")
    @Min(value = 1, message = "El precio minimo permitido por metro cuadrado es 1 U$S.")
    @Max(value = 4000, message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    @JsonProperty("district_price")
    private double price;
}

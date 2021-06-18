package com.meli.desafio2.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {
    @Valid
    @NotEmpty(message = "El nombre del barrio no puede estar vacío.")
    @NotNull(message = "El nombre del barrio no puede ser nulo.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String district_name;
    @Valid
    @NotNull(message = "El precio de un barrio no puede ser nulo.")
    @Max(value = 4000, message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    @Min(value = 0, message = "El precio por metro cuadrado no puede ser menor a 0.")
    private double district_price;
}

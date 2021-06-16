package com.meli.testingchallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
public class EstateDTO {

    @NotNull(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*",  message ="El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String prop_name;
    @NotNull(message = "El barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String district_name;
    @NotNull(message = "El precio de un barrio no puede estar vacío.")
    @Max(value=4000, message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    @Min(value=1, message = "El precio mínimo permitido por metro cuadrado no puede ser inferior a 1 U$S.")
    private double district_price;
    @NotEmpty(message = "Cada propiedad debe tener al menos un ambiente")
    private List<@Valid EnvironmentDTO> environments;

}

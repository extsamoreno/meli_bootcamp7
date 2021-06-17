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
public class EnvironmentSquareMetterDTO extends EnvironmentDTO{
    public EnvironmentSquareMetterDTO(
            @Valid @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
            @NotNull(message = "El nombre del ambiente no puede ser nulo.")
            @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
            @Size(min = 1, message = "La longitud del nombre debe ser al menos 1 caracter.")
            @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.") String name,
            @Valid @NotNull(message = "El ancho del ambiente no puede estar vacío.")
            @Min(value = 1, message = "El ancho minimo permitido es de 1 mts.")
            @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts.") double width,
            @Valid @NotNull(message = "El largo del ambiente no puede estar vacío.")
            @Min(value = 1, message = "El largo minimo permitido es de 1 mts.")
            @Max(value = 33, message = "El máximo largo permitido por propiedad es de 33 mts.") double length,
            double squareMetters) {
        super(name, width, length);
        this.squareMetters = squareMetters;
    }

    @JsonProperty("environment_square_metters")
    private double squareMetters;
}

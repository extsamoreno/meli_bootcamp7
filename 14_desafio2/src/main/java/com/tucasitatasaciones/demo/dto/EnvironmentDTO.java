package com.tucasitatasaciones.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentDTO {

    @Valid
    @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
    @NotNull(message = "El nombre del ambiente no puede ser nulo.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(min = 1, message = "La longitud del nombre debe ser al menos 1 caracter.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @JsonProperty("environment_name")
    private String name;

    @Valid
    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @Min(value = 1, message = "El ancho minimo permitido es de 1 mts.")
    @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts.")
    @JsonProperty("environment_width")
    private double width;

    @Valid
    @NotNull(message = "El largo del ambiente no puede estar vacío.")
    @Min(value = 1, message = "El largo minimo permitido es de 1 mts.")
    @Max(value = 25, message = "El máximo largo permitido por propiedad es de 33 mts.")
    @JsonProperty("environment_length")
    private double length;
}

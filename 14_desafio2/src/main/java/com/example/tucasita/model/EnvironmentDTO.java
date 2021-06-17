package com.example.tucasita.model;

import lombok.*;

import javax.validation.constraints.*;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EnvironmentDTO {

    @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String environmentName;

    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @DecimalMin(value= "0.0", message = "El mínimo ancho permitido por propiedad es de 0 mts.")
    @DecimalMax(value= "25.0", message = "El máximo ancho permitido por propiedad es de 25 mts.")
    Double evironmentWidth;

    @NotNull(message = "El precio de un barrio no puede estar vacío.")
    @DecimalMin(value= "0.0", message = "El mínimo largo permitido por propiedad es de 0 mts.")
    @DecimalMax(value= "33.0", message = "El máximo largo permitido por propiedad es de 33 mts.")
    Double environmentLength;

    Double squareMeters;
}
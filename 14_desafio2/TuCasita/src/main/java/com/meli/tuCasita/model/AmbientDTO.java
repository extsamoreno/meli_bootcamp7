package com.meli.tuCasita.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AmbientDTO {
    @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre de la materia no puede superar los 30 caracteres.")
    String name;

    @NotNull(message = "El largo no puede estar vacía.")
    @DecimalMin(value = "0.1", message = "El largo mínima es de 0.1 pts.")
    @DecimalMax(value = "33.0", message = "El largo maximo es de 33.0 pts.")
    Double longAmbient;

    @NotNull(message = "El ancho no puede estar vacía.")
    @DecimalMin(value = "0.1", message = "El ancho mínima es de 0.1 pts.")
    @DecimalMax(value = "25.0", message = "El ancho maximo es de 25.0 pts.")
    Double widthAmbient;
}

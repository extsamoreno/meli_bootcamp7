package com.desafiotesting.desafiotesting.services.dtos;
import lombok.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnviromentDTO {
    @NotBlank(message = "El nombre del ambiente no puede estar vacio")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre del ambiente no puede superar los 30 caracteres.")
    String name;

    @NotBlank(message = "El ancho del ambiente no puede estar vacio")
    @DecimalMax(value = "25", message = "el maximo ancho por propiedad es de 25ms")
    double width;
    @NotBlank(message = "El largo del ambiente no puede estar vacio")
    @DecimalMax(value = "33", message = "el maximo largo por propiedad es de 33ms")
    double length;
}

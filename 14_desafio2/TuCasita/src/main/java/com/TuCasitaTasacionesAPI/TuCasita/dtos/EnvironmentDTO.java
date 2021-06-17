package com.TuCasitaTasacionesAPI.TuCasita.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentDTO {

    @NotEmpty(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(min = 1, max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String environment_name;

    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @Min(value = 0, message = "El ancho no puede ser menor a 0.")
    @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts.")
    private Double environment_width;

    @NotNull(message = "El largo del ambiente no puede estar vacío.")
    @Min(value = 0, message = "El largo no puede ser menor a 0.")
    @Max(value = 33, message = "El máximo largo permitido por propiedad es de 33 mts.")
    private Double environment_length;
}

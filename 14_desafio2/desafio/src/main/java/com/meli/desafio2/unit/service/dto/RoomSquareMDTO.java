package com.meli.desafio2.unit.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class RoomSquareMDTO extends RoomDTO {
    private Double SquareMeters;

    public RoomSquareMDTO(@NotBlank(message = "El nombre del ambiente no puede estar vacío.") @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del ambiente debe comenzar con mayúscula.") @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.") String name, @NotNull(message = "El ancho del ambiente no puede estar vacío.") @DecimalMax(value = "25.0", message = "El máximo ancho permitido por propiedad es de 25 mts.") Double width, @NotNull(message = "El ancho del ambiente no puede estar vacío.") @DecimalMax(value = "33.0", message = "El máximo largo permitido por propiedad es de 33 mts. Como los orientales") Double length, Double squareMeters) {
        super(name, width, length);
        SquareMeters = squareMeters;
    }
}

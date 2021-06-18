package com.example.DesafioTasaciones.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {
    @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @DecimalMax(value="25.0", message = "El máximo ancho permitido por propiedad es de 25 mts.")
    @Positive(message = "El ancho de un ambiente no puede ser negativo ni cero.")
    private Double width;

    @NotNull(message = "El largo del ambiente no puede estar vacío.")
    @DecimalMax(value="33.0", message = "El máximo largo permitido por propiedad es de 33 mts.")
    @Positive(message = "El largo de un ambiente no puede ser negativo ni cero.")
    private Double length;

    private Double squareMeters;

    public RoomDTO(String name,Double width,Double length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }

}

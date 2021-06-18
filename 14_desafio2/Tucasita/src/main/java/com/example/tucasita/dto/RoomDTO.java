package com.example.tucasita.dto;

import lombok.*;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class RoomDTO {
    @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;
    @NotNull(message = "EL ancho del ambiente no puede estar vacio")
    @DecimalMax(value = "25.0", message = "El máximo ancho permitido por propiedad es de 25 mts.")
    @DecimalMin(value = "0.01", message = "El ancho debe ser mayor a 0.0 mts.")
    private Double width;
    @NotNull(message = "EL largo del ambiente no puede estar vacio")
    @DecimalMax(value = "33.0", message = "El máximo largo permitido por propiedad es de 33 mts.")
    @DecimalMin(value = "0.01", message = "El largo debe ser mayor a 0.0 mts.")
    private Double length;
}

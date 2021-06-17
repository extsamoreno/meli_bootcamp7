package com.example.tucasita.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomDTO {
    @NotBlank(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp = "([A-Z][a-zäÄëËïÏöÖüÜáéíóúáéíóúÁÉÍÓÚÂÊÎÔÛâêîôûàèìòùÀÈÌÒÙ]+[\\p{Space}]*)*", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;
    @NotEmpty(message = "EL ancho del ambiente no puede estar vacio")
    @DecimalMax(value = "25.0", message = "El máximo ancho permitido por propiedad es de 25 mts.")
    @DecimalMin(value = "0.0", message = "El ancho debe ser mayor a 0.0 mts.")
    private double width;
    @NotEmpty(message = "EL largo del ambiente no puede estar vacio")
    @DecimalMax(value = "33.0", message = "El máximo largo permitido por propiedad es de 33 mts.")
    @DecimalMin(value = "0.0", message = "El largo debe ser mayor a 0.0 mts.")
    private double length;
}

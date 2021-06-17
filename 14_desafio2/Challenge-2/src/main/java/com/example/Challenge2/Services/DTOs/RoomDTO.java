package com.example.Challenge2.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class RoomDTO extends StructureDTO {


    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "^[A-Z][0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]*$", message = "El nombre del ambiente debe comenzar con mayúscula.")
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    private String name;

    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @DecimalMax(value = "25.0", message = "El máximo ancho permitido por propiedad es de 25 mts.", inclusive = true)
    private double width;

    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @DecimalMax(value = "33.0", message = "El máximo largo permitido por propiedad es de 33 mts.", inclusive = true)
    private double length;





}

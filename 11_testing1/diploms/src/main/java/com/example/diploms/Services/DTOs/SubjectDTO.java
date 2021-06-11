package com.example.diploms.Services.DTOs;

import lombok.*;

import javax.validation.constraints.*;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class SubjectDTO {

    @NotEmpty(message = "El nombre de la materia no puede estar vacío")
    @Pattern(regexp = "^[A-Z][a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*$", message = "El nombre de la materia debe comenzar con mayúscula")
    @Size (max = 50, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String name;


    @DecimalMax(value = "10.0", message = "La maxima nota es 10.0", inclusive = true)
    @DecimalMin(value = "0.0", message = "La mínima nota es 0.0", inclusive = true)
    @NotNull(message = "La nota no puede estar vacía")
    private double score;

}

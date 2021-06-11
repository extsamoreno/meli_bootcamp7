package com.example.diploms.Services.DTOs;

import lombok.*;

import javax.validation.constraints.*;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class SubjectDTO {

    @NotEmpty(message = "El nombre de la materia no puede estar vacío")
    @Pattern(regexp = "/^[A-Z][a-z0-9_-]$/", message = "El nombre de la materia debe comenzar con mayúscula")
    @Size (max = 50, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String name;

    @NotEmpty(message = "La nota no puede estar vacía")
    @Max(value = 10, message = "La maxima nota es 10.0")
    @Min(value = 0, message = "La mínima nota es 0.0")
    private double score;

}

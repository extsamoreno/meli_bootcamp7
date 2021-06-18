package com.desafio2.demo.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentDTO {
    @NotEmpty(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp = "[A-ZÀ-ÿ].*", message = "El nombre del ambiente no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull
    @Positive
    @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts.")
    private double width;

    @NotNull
    @Positive
    @Max(value = 33, message = "El máximo largo permitido por propiedad es de 33 mts.")
    private double length;

    public double area(){
        return this.width * this.length;
    }
}

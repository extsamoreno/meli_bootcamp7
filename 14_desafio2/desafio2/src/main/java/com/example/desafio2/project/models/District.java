package com.example.desafio2.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
    @NotBlank(message = "The district name cannot be empty")
    @Size(max = 30, message = "The max length is 45 characters")
    private String district_name;


    @NotNull(message = "The district price cannot be null")
    @DecimalMax(value="4000.0", message = "The district price cannot be higher than 4000 U$D")
    @Positive(message = "El precio de un barrio no puede ser negativo ni cero.")
    private double district_price;
}

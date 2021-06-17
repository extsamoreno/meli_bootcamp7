package com.meli.desafio2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @NotNull(message = "The id is required")
    private int id;

    @Size(message = "The length of the name cannot exceed 45 characters", max = 45)
    @NotEmpty(message = "District name cannot be empty")
    private String district_name;

    @NotNull(message = "District price cannot be empty")
    @Max(value = 4000, message = "The maximum price allowed per square meter cannot exceed 4000 U$S")
    private double district_price;
}

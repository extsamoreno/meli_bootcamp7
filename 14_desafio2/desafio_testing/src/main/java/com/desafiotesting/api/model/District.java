package com.desafiotesting.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @NoArgsConstructor
@Data
public class District {

    @NotEmpty(message = "The name of the district cant be empty.")
    @Size(max = 45, message = "The length of the district name no can exceed 45 characters.")
    private String name;

    @NotNull(message = "The price of a neighborhood cant be empty.")
    @DecimalMax(value = "4000", message = "The maximum price allowed per square meter no can exceed 4000 U$S.")
    private Double price;
}

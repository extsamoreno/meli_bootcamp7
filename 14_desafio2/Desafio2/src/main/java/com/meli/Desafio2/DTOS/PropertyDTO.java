package com.meli.desafio2.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    @NotBlank(message = "The property name cannot be empty.")
    @Pattern(regexp="^([A-Z].*)$|^$", message = "The property name must begin with a capital letter.")
    @Size(max = 30, message = "The length of the property name cannot exceed 30 characters")
    private String nameProperty;

    private List<@Valid EnvironmentDTO> environment;

    @NotBlank(message = "The district cannot be empty")
    @Size(max = 45, message = "The length of the district cannot exceed 45 characters")
    private String nameDistrict;

    @NotNull(message = "the price of a district cannot be empty")
    @Max(value = 4000, message = "The maximum price allowed per square meter cannot exceed $US4000")
    private double priceDistrict;
}

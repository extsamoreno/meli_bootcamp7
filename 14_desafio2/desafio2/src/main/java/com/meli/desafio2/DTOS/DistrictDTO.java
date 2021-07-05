package com.meli.desafio2.dtos;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {
    @NotBlank(message = "The district cannot be empty.")
    @Size(max = 45, message = "The length of the district cannot exceed 45 characters.")
    private String nameDistrict;

    @NotNull(message = "the price of a district cannot be empty")
    @Max(value = 4000, message = "The maximum price allowed per square meter cannot exceed $US4000.")
    private Double priceDistrict;
}

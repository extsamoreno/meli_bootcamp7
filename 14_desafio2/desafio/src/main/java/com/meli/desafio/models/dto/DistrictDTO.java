package com.meli.desafio.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {
    @Size(max = 45, message = "The name of the district cannot contain more than 45 characters")
    @NotEmpty(message = "The district must have a name")
    private String name;

    @Positive(message = "The price cannot be less than or equal to 0")
    @Max(value = 4000, message = "The price cant be higher of 4000")
    private double price;
}

package com.desafiotesting.api.dto;

import com.desafiotesting.api.model.District;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor @NoArgsConstructor
@Data
public class DistrictDTO {

    @NotEmpty(message = "The name of the district cant be empty.")
    @Size(max = 45, message = "The length of the district name no can exceed 45 characters.")
    private String name;

    @NotNull(message = "The price of a neighborhood cant be empty.")
    @DecimalMax(value = "4000", message = "The maximum price allowed per square meter no can exceed 4000 U$S.")
    @DecimalMin(value = "0", message = "The price cant be negative.")
    private Double price;
}

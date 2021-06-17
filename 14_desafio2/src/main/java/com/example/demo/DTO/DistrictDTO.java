package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {

    @NotBlank(message = "District can't be empty")
    @Size(max = 45, message = "The length of the neighborhood cannot exceed 45 characters")
    private String name;

    @NotNull(message = "Price can't be empty")
    @DecimalMax(value="4000.0", message = "The maximum price allowed per square meter cannot exceed 4000 U$S")
    @Positive(message = "The price must be positive")
    private Double price;
}

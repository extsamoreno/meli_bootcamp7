package com.example.tuCasita.dtos;

import lombok.*;

import javax.validation.constraints.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {
    Integer id;

    @NotBlank(message = "The district cannot be empty.")
    @Size(max = 45, message = "The length of the district cannot exceed 45 characters.")
    private String name;

    @NotNull(message = "The price of a district cannot be empty.")
    @DecimalMax(value="4000.0", message = "The maximum price allowed per square meter cannot exceed 4000 U $ S.")
    @Positive(message = "The price of a district cannot be negative or zero.")
    private Double price;
}

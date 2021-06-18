package com.example.testingchallengev2.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {
    @NotEmpty(message = "Empty name not allowed.")
    @Pattern(regexp = "[A-Z1-9\\u00d1][\\ A-Za-zà-ÿ0-9\\u00f1]+",
            message = "Capitalized name required.")
    @Size(max = 45, message = "Name length must be 45 characters or less.")
    private String name;
    @NotNull
    @DecimalMax(value = "4000.0",
            message = "Prices higher than 4000 are not allowed.")
    @DecimalMin(value = "0.0", inclusive = false,
            message = "District properties must have a monetary value.")
    private double price;
}

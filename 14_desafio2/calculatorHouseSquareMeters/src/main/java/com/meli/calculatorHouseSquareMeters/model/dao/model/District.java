package com.meli.calculatorHouseSquareMeters.model.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @NotNull(message = "The attribute 'districtName' must not be Null")
    @Size(min = 1, max = 45, message = "The 'districtName' attribute cannot exceed 30 characters")
    @NotEmpty(message = "The 'districtName' attribute must not be empty")
    @Pattern(regexp = "^[A-Z].*$", message="The attribute 'districtName' must start in uppercase")
    private String districtName;

    @NotNull(message = "The attribute 'squareMeterPrice' must not be Null")
    @Max(value = 4000, message = "The 'squareMeterPrice' must be maximum 25")
    @Min(value = 1, message = "The 'squareMeterPrice' must be minimum 1")
    @Positive(message = "The 'squareMeterPrice' must be positive")
    private double squareMeterPrice;
}

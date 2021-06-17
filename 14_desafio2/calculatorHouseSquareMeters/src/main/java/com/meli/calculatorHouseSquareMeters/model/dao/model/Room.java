package com.meli.calculatorHouseSquareMeters.model.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @NotNull(message = "The attribute 'name' must not be Null")
    @Size(max = 30, message = "The 'name' attribute cannot exceed 30 characters")
    @NotEmpty(message = "The 'name' attribute must not be empty")
    @Pattern(regexp = "^[A-Z].*$", message="The attribute 'name' must start in uppercase")
    private String name;

    @NotNull(message = "The attribute 'width' must not be Null")
    @Max(value = 25, message = "The 'width' must be maximum 25")
    @Min(value = 1, message = "The 'width' must be minimum 1")
    @Positive(message = "The 'width' must be positive")
    private double width;

    @NotNull(message = "The attribute 'length' must not be Null")
    @Max(value = 33, message = "The 'length' must be maximum 33")
    @Min(value = 1, message = "The 'length' must be minimum 1")
    @Positive(message = "The 'length' must be positive")
    private double length;
}

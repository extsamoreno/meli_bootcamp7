package com.desafiotesting.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor @NoArgsConstructor
@Data
public class EnvironmentDTO {

    @NotEmpty(message = "The name of the environment it cant be empty.")
    @Pattern(regexp="^[A-Z].*",message="The name of the environment should start with capital letter.")
    @Size(max = 30, message = "The length of the name no can exceed 30 characters.")
    private String name;

    @NotNull(message = "The width of the environment it cant be empty.")
    @DecimalMax(value = "25", message = "The maximum width allowed per property is 25 meters.")
    @DecimalMin(value = "0", message = "The width of the environment should not be negative")
    private Double width;

    @NotNull(message = "The length of the environment it cant be empty.")
    @DecimalMax(value = "33", message = "The maximum length allowed per property is 33 meters.")
    @DecimalMin(value = "0", message = "The length of the environment should not be negative")
    private Double length;
}

package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentDTO {

    private int id;

    @NotBlank(message = "Name can't be empty")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "The name of the environment must begin with a capital letter")
    @Size(max = 30, message = "The length of the neighborhood cannot exceed 30 characters")
    private String name;

    @NotNull(message = "Width can;t be empty")
    @DecimalMax(value = "25.0", message = "The maximum width allowed is 25 meters")
    @Positive(message = "The width cannot be negative or zero.")
    private Double width;

    @NotNull(message = "Length can't be empty")
    @DecimalMax(value = "33.0", message = "The maximum length allowed is 33 meters")
    @Positive(message = "The length cannot be negative or zero.")
    private Double length;


    private double totalMeters;

}

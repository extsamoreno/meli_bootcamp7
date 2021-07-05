package com.meli.desafio2.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class EnvironmentDTO {
    @NotBlank(message = "The environment name cannot be empty.")
    @Pattern(regexp="^([A-Z].*)$|^$", message = "The environment name must begin with a capital letter.")
    @Size(max = 30, message = "The length of the environment name cannot exceed 30 characters")
    private String nameEnvironment;

    @NotNull(message = "The environment widht cannot be empty.")
    @Max(value = 25, message = "The maximum width allowed per property is 25 meters.")
    private Integer width;

    @NotNull(message = "The environment lenght cannot be empty.")
    @Max(value = 33, message = "The maximum width allowed per property is 33 meters.")
    private Integer length;
}

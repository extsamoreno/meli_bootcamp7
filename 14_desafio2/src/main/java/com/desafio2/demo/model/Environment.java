package com.desafio2.demo.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
    @NotBlank(message = "The environment name cannot be empty.")
    @Pattern(regexp="([A-Z]|Á|Ó|É|Í|Ú)(([a-z]|[á-ú]|é|ñ)*(\\s)?)(([A-Z]|Á|Ó|É|Í|Ú)?(([a-z]|[á-ú]|é|ñ)*(\\s)?)+)*[0-9]?",
            message = "The name of the environment must begin with a capital letter.")
    @Size(max = 30, message = "The length of the environment name cannot exceed 30 characters.")
    private String name;

    @NotNull(message = "The width of the room cannot be empty.")
    @Positive(message = "\n" + "The width must be greater than 0.00.")
    @DecimalMax(value = "25.0", message = "The maximum width allowed per property is 25.0 meters.")
    private Double width;

    @NotNull(message = "The length of the room cannot be empty.")
    @Positive(message = "The length must be greater than 0.00.")
    @DecimalMax(value = "33.0", message = "The maximum length allowed per property is 33.0 meters.")
    private Double length;
}

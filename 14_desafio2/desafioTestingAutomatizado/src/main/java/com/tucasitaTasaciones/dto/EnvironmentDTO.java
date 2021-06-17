package com.tucasitaTasaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentDTO {

    @NotNull(message = "Environment name cannot be empty")
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",
            message = "Enviroment name must start with a capital letter")
    @Size(min = 1, max = 30, message = "The length of the name cannot exceed 30 characters.")
    private String environment_name;

    @NotNull(message = "environment_width cannot be empty")
    @Size(min = 1, max = 25, message = "The maximum width allowed is 25 meters.")
    private Integer environment_width;

    @NotNull(message = "environment_length cannot be empty")
    @Size(min = 1, max = 33, message = "The minimum width allowed is 33 meters.")
    private Integer environment_length;


}

package com.example.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentDTO {

    @NotBlank(message = "Environment name cannot be void.")
    @Size(max = 30, message = "Environment name length cannot surpass 30 characters.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "Environment name must have first letter captioned.")
    private String name;

    private Double squareMeters;
}

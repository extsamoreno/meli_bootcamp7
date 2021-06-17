package com.example.desafio2.project.services.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyEnvironmentDto {
    @NotBlank(message = "The environment name cannot be empty\"")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z]*$", message = "The environment name must start with a capital letter")
    @Size(max = 30, message = "The environment name max length is 30 characters")
    private String environment_name;

    private double environment_size;
}

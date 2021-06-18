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

public class Neighborhood {
    @NotBlank(message = "The neighborhood name cannot be empty.")
    @Pattern(regexp="([A-Z]|Á|Ó|É|Í|Ú)(([a-z]|[á-ú]|é|ñ)*(\\s)?)(([A-Z]|Á|Ó|É|Í|Ú)(([a-z]|[á-ú]|é|ñ)*(\\s)?)+)*[0-9]?",
            message = "The name of the neighborhood must begin with a capital letter.")
    @Size(max = 45, message = "The length of the neighborhood name cannot exceed 30 characters.")
    private String name;

    @NotNull(message = "The width of the room cannot be empty.")
    @Positive(message = "The width must be greater than 0.00.")
    @DecimalMax(value = "4000.0",
            message = "The maximum price allowed per square meter cannot exceed 4000 U$S.")
    private Double price;

    public void setId(int id) {
    }
}

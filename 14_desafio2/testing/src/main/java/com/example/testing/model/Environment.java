package com.example.testing.model;

import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {

    @NotBlank(message = "Environment name cannot be void.")
    @Size(max = 30, message = "Environment name length cannot surpass 30 characters.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "Environment name must have first letter captioned.")
    private String name;

    @NotNull(message = "Environment width cannot be void.")
    @DecimalMax(value = "25.0", message = "Environment width cannot be over 25 mts.")
    private Double width;

    @NotNull(message = "Environment length cannot be void.")
    @DecimalMax(value = "33.0", message = "Environment length cannot be over 33 mts.")
    private Double length;

    public Double getSquareMeters(){
        return this.length * this.width;
    }
}

package com.example.tuCasita.dtos;

import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnviromentDTO {
    private Integer id;

    @NotBlank(message = "The environment name cannot be empty.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "The name of the environment must begin with a capital letter.")
    @Size(max = 30, message = "The length of the name cannot exceed 30 characters")
    private String name;

    @NotNull(message = "The width of the room cannot be empty.")
    @DecimalMax(value="25.0", message = "The maximum width allowed per property is 25 meters.")
    @Positive(message = "The width of a room cannot be negative or zero.")
    private Double width;

    @NotNull(message = "The length of the room cannot be empty.")
    @DecimalMax(value="33.0", message = "The maximum length allowed per property is 33 meters.")
    @Positive(message = "The length of an environment cannot be negative or zero.")
    private Double length;
}

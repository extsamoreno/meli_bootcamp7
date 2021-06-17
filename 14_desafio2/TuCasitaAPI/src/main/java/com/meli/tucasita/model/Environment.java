package com.meli.tucasita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Environment {
    @Size(max = 30,message = "The environment's name can't be larger than 30 length")
    @NotEmpty(message = "The environment's name can't be null or empty")
    @Pattern(regexp = "^[A-Z].*", message = "The environment's name must start with capital letter")
    private String name;
    @PositiveOrZero(message = "The environment's width can't be less than 0")
    @NotNull(message = "The environment's width can't be null")
    @Max(value = 25, message = "The environment's width can't be more than 25 mts")
    private double width;
    @PositiveOrZero(message = "The environment's length can't be less than 0")
    @NotNull(message = "The environment's length can't be null")
    @Max(value = 33, message = "The environment's length can't be more than 33 mts")
    private double length;
}

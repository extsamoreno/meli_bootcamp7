package com.meli.desafio2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Size(message = "The length of the name cannot exceed 30 characters", max = 30)
    //@Pattern(regexp = "[A-Z][a-zA-Z]", message = "The property name must begin with a capital letter")
    @NotEmpty(message = "Property name cannot be empty")
    private String prop_name;

    @NotNull(message = "District cannot be empty")
    private @Valid District district;

    @NotEmpty(message = "Enviroments cannot be empty")
    private List<@Valid Environment> environmentList;

}

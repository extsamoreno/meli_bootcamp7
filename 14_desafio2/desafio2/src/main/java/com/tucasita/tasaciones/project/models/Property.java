package com.tucasita.tasaciones.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @NotBlank(message = "The property name cannot be empty")
    @Size(max = 30, message = "The property name max length is 30 characters")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z]*$", message = "The property name must start with a capital letter")
    private String prop_name;

    @NotBlank(message = "The district name cannot be empty")
    @Size(max = 30, message = "The max length is 45 characters")
    private String prop_district_name;

    private ArrayList<@Valid Environment> prop_environment;
}

package com.example.testing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    private int id;

    @NotBlank(message = "Property name cannot be void.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "Property name must have first letter captioned.")
    @Size(max = 30, message = "Property name length cannot surpass 30 characters.")
    private String name;
    private District district;
    private ArrayList<Environment> environments = new ArrayList<>();

}

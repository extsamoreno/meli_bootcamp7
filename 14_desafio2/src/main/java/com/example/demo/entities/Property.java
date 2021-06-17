package com.example.demo.entities;

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

    private int id;

    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "The name of the property must begin with a capital letter")
    @NotBlank(message = "The name can't be empty")
    @Size(max = 30, message = "The length of the name cannot exceed 30 characters")
    private String name;
    private District district;
    private List<Environment> environments;

}
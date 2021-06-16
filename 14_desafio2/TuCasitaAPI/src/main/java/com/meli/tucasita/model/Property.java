package com.meli.tucasita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @Max(value = 30,message = "The property's name can't be larger than 30 length")
    @NotEmpty(message = "The property's name can't be null or empty")
    @Pattern(regexp = "^[A-Z]([A-Za-z])*", message = "The property's name must start with capital letter")
    private String name;
    @NotEmpty(message = "The property's district can't be null or empty")
    private District district;
    @NotEmpty(message = "The property's environments can't be null or empty")
    private List<Environment> environments;
}

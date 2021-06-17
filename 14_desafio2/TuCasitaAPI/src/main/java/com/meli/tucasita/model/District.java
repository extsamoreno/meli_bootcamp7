package com.meli.tucasita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {

    @Size(max = 45, message = "The district's name can't be larger than 45 length")
    @NotEmpty(message = "The district's name can't be null or empty")
    private String name;
    @PositiveOrZero(message = "The district's price can't be less than 0$")
    @NotNull(message = "The district's price can't be null")
    @Max(value = 4000, message = "The district's price can't be more than 4000 US$")
    private double price;
}

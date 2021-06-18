package com.example.challenge2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @NotBlank(message = "The district name can not be empty")
    @Size(max = 45, message = "The district name can not be longer than 45 characters ")
    private String name;

    @DecimalMax(value="400.0", message = "The price can not be more than 400 characters ")
    @Positive(message = "The price can not be under 0")
    private Double price;

}

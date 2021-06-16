package com.meli.desafio.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class District {
    @Size(max = 45, message = "The name of the district cannot contain more than 45 characters")
    @NotBlank
    private String name;

    @NotBlank
    @Positive
    @Max(4000)
    private double price;
}

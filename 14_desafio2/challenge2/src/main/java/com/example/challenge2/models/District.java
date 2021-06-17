package com.example.challenge2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @NotBlank(message = "The name can not be empty")
    @Size(max = 45, message = "The District name can not be longer than 45 characters ")
    private String name;
    @Size(max = 400, message = "Can not be longer than 30 characters ")
    private Double price;

}

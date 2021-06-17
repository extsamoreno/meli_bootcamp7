package com.example.challenge2.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {

    @NotBlank(message = "The name can not be empty")
    @Pattern(regexp="([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "The environment name should start with capital letter")
    @Size(max = 30, message = "Can not be longer than 30 characters ")
    private String name;
    @Size(max = 25, message = "Width can not be longer than 25")
    private Double width;
    @Size(max = 33, message = "Length can not be longer than 33")
    private Double length;
}

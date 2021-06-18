package com.desafio2.demo.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Property {
    @NotBlank(message = "The property name cannot be empty.")
    @Pattern(regexp="([A-Z]|Á|Ó|É|Í|Ú)(([a-z]|[á-ú]|é|ñ)*(\\s)?)(([A-Z]|Á|Ó|É|Í|Ú)?(([a-z]|[á-ú]|é|ñ)*(\\s)?)+)*[0-9]?",
            message = "The property name must start with a capital letter.")
    @Size(max = 30, message = "The length of the property name cannot exceed 30 characters.")
    private String name;

    private String address;

    @NotBlank(message = "The neighborhood cannot be empty.")
    @Pattern(regexp="([A-Z]|Á|Ó|É|Í|Ú)(([a-z]|[á-ú]|é|ñ)*(\\s)?)(([A-Z]|Á|Ó|É|Í|Ú)(([a-z]|[á-ú]|é|ñ)*(\\s)?)+)*[0-9]?",
            message = "The name of the neighborhood must begin with a capital letter.")
    @Size(max = 45, message = "The length of the neighborhood cannot exceed 45 characters.")
    private String neighborhood;

    @NotEmpty(message = "The list of environments cannot be empty.")
    private List<@Valid Environment> environments;
}
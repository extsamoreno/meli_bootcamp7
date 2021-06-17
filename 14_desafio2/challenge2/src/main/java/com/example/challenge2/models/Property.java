package com.example.challenge2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NotNull
public class Property {

    @NotBlank(message = "The name can not be empty")
    @Pattern(regexp="([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "The name should start with capital letter")
    @Size(max = 30, message = "Can not be longer than 30 characters ")
    private String name;
    @Valid
    private District district;
    @Valid
    private List<Environment> environmentList;
}

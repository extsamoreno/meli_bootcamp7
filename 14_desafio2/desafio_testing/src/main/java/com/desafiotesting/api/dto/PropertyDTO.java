package com.desafiotesting.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@NoArgsConstructor @AllArgsConstructor
@Data
public class PropertyDTO {

    @NotEmpty(message = "The name of the property it cant be empty.")
    @Pattern(regexp="^[A-Z].*",message="The name of the property should start with capital letter.")
    @Size(max = 50, message = "The length of the name no can exceed 30 characters.")
    private String name;

    @NotEmpty(message = "The name of the district it cant be empty.")
    @Size(max = 30, message = "The length of the district name no can exceed 30 characters.")
    private String district;
    private ArrayList<@Valid EnvironmentDTO> environments;
}

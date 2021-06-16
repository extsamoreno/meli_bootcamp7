package com.example.challenge_2.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PropertyDTO {

    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp = "^[A-Z]\\w*$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    private @Valid DistrictDTO district;
    private List<@Valid EnvironmentDTO> environments;
}

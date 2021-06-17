package com.tuCasita.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {

    @NotEmpty(message = "El nombre de la propiedad no puede estar vacio.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "[A-Z].*", message = "El nombre de la propiedad debe comenzar con mayuscula.")
    private String name;

    @NotNull
    private @Valid DistrictDTO district;

    @NotEmpty
    private ArrayList<@Valid EnvironmentDTO> environments;
}

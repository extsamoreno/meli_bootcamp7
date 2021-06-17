package com.example.demo.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyRequestDTO {
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacio.")
    @Pattern(regexp = "[A-Z\\u00d1][a-zà-ÿ\\u00f1]*", message = "El nombre de la propiedad debe empezar con una mayuscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String prop_name;

    @NotNull(message = "El barrio no puede estar vacio.")
    private DistrictDTO district;

    @NotEmpty (message = "La lista de ambientes no puede estar vacia.")
    private List<@Valid EnvironmentRequestDTO> environment;
}

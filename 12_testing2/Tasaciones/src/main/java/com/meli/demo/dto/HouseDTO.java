package com.meli.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO {

    @NotNull(message = "El nombre de la propiedad no puede estar vacío.")
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Size(min = 3, message = "La longitud minima del nombre de la propiedad debe ser mayor que 3.")
    private String name;

    @NotNull(message = "El barrio no puede estar vacía.")
    private @Valid NeighborhoodDTO neighborhood;


    @NotEmpty(message = "La lista de materias no puede estar vacía.")
    private @Valid ArrayList<EnvironmentDTO> environments;

}

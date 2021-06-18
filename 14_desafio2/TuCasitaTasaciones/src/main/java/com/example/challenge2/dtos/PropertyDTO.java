package com.example.challenge2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PropertyDTO {

    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la propiedad debe comenzar con una mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotEmpty(message = "El nombre del barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String district;
    private ArrayList<@Valid EnvironmentDTO> environments;


}
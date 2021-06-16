package com.desafio2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp = "\\b([A-Z])(\\S*?)\\b", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String prop_name;

    @NotBlank(message = "El nombre del barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del nombre del barrio no puede superar los 45 caracteres")
    private String district_name;

    @NotEmpty(message = "La lista de habitaciones no puede estar vacía.")
    private List<Environment> environments;
}

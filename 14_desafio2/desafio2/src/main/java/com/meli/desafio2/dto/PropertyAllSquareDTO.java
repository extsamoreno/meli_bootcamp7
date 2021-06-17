package com.meli.desafio2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyAllSquareDTO {
    private int prop_id;
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30,message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String prop_name;
    @NotEmpty(message = "La propiedad debe contener hambientes")
    @Valid
    private ArrayList<EnviromentSquareDTO> enviroments;
}
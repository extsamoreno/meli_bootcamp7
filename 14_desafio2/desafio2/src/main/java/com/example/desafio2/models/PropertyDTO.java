package com.example.desafio2.models;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    private int id;

    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp="([A-Z]|Á|Ó|É|Í|Ú)(([a-z]|[á-ú]|é|ñ)*(\\s)?)(([A-Z]|Á|Ó|É|Í|Ú)?(([a-z]|[á-ú]|é|ñ)*(\\s)?)+)*[0-9]?",
            message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre de la propiedad no puede superar los 30 caracteres.")
    private String name;

    private String address;

    @NotBlank(message = "El barrio no puede estar vacío.")
    @Pattern(regexp="([A-Z]|Á|Ó|É|Í|Ú)(([a-z]|[á-ú]|é|ñ)*(\\s)?)(([A-Z]|Á|Ó|É|Í|Ú)(([a-z]|[á-ú]|é|ñ)*(\\s)?)+)*[0-9]?",
            message = "El nombre del barrio debe comenzar con mayúscula.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String neighborhood;

    @NotEmpty(message = "La lista de ambientes no puede estar vacía.")
    private List<@Valid EnvironmentDTO> environments;
}

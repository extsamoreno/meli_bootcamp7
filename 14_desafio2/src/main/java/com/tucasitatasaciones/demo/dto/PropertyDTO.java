package com.tucasitatasaciones.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    private int id;

    @Valid
    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @NotNull(message = "El nombre de la propiedad no puede ser nulo.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(min = 1, message = "La longitud del nombre debe ser al menos 1 caracter.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @JsonProperty("prop_name")
    private String name;

    @Valid
    @Min(value = 1, message = "El id de barrio debe ser mayor a 0.")
    @JsonProperty("district_id")
    private int districtId;

    @Valid
    private ArrayList<EnvironmentDTO> environments;
}

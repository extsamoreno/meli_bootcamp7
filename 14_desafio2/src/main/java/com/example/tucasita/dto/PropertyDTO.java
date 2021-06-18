package com.example.tucasita.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PropertyDTO {
    private int propId;

    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String propName;

    @NotBlank(message = "El barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String districtName;

    @NotEmpty(message = "La lista de ambientes no puede estar vacía.")
    private List<@Valid EnvironmentDTO> environments;
}
package com.desafiotesting.desafiotesting.services.dtos;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyDTO {
    int id;
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacio")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotEmpty(message = "El nombre del barrio no puede estar vacio")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del barrio debe comenzar con mayúscula.")
    @Size(max = 45, message = "La longitud del nombre del barrio no puede superar los 45 caracteres.")
    private String districtName;
    private List<@Valid EnviromentDTO> enviroments;
}

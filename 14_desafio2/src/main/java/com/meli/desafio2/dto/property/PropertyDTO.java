package com.meli.desafio2.dto.property;

import com.meli.desafio2.dto.environment.EnvironmentDTO;
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
public class PropertyDTO {

    @NotNull(message = "El id de la propiedad no puede estar vacio")
    private Integer id;

    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la propiedad debe comenzar con mayúscula")
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacio")
    @Size(max = 30, message = "La longitud del nombre de la propiedad no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "El id del barrio no puede estar vacio")
    private Integer districtId;

    @NotEmpty(message = "La lista de ambientes no puede estar vacia")
    private List<@Valid EnvironmentDTO> environments;
}

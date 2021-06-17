package com.meli.desafio2.web.dto;

import com.meli.desafio2.web.model.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {
    @Valid
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío." )
    @NotNull(message = "El nombre de la propiedad no puede ser nulo")
    @Pattern(regexp = "^[A-Z].*$", message ="El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String prop_name;
    @Valid
    @NotNull(message = "El barrio no puede ser nulo")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String district;
    @Valid
    @NotNull(message = "La lista no puede ser nula.")
    private List<EnvironmentDTO> environments;
}

package com.meli.tuCasita.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {

    Long id;

    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud de la casa del estudiante no puede superar los 50 caracteres.")
    String houseName;

    @NotNull
    District district;

    @NotEmpty(message = "La lista de ambientes no puede estar vacía.")
    List<@Valid Ambient> ambient;
}

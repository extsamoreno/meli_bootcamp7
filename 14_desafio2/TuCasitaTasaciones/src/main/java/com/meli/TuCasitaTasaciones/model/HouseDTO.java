package com.meli.TuCasitaTasaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO {
    @NotNull(message = "El barrio no puede estar vacío.")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del barrio debe comenzar con mayúscula.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    String district;

    List< @Valid EnvironmentDTO> environments;
}

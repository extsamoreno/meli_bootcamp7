package com.bootcamp.tucasitatasaciones.DTO;

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
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {

    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp = "[A-ZÀ-Ú][A-Za-zÀ-ú0-9 ]*", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull(message = "El barrio es un campo obligatorio.")
    private @Valid DistrictDTO district;

    @NotNull(message = "La lista de ambientes es un campo obligatorio")
    private List<@Valid EnvironmentDTO> environments;
}

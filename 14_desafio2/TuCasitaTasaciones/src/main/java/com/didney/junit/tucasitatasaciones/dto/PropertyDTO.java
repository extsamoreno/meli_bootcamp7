package com.didney.junit.tucasitatasaciones.dto;

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
    @NotNull(message = "El nombre de la propiedad no puede ser nulo.")
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    private String propName;
    @Valid
    private DistrictDTO district;
    @Valid
    private List<EnvironmentDTO> environments;
}

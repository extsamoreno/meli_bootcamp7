package com.TuCasitaTasacionesAPI.TuCasita.dtos;

import com.TuCasitaTasacionesAPI.TuCasita.models.Environment;
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

    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(min = 1, max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String prop_name;

    @NotNull(message = "El id de barrio no puede estar vacío.")
    private Integer district_id;

    @NotEmpty(message = "La lista de ambientes no puede ser vacía.")
    private @Valid List<EnvironmentDTO> environments;
}

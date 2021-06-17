package com.meli.desafio2.unit.service.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PropertyDTO {
    Long id;

    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;

    @Valid
    DistrictDTO district;

    List<@Valid RoomDTO> rooms;
}

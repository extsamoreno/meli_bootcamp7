package com.example.desafio2.service.DTO;

import com.example.desafio2.model.Neighborhood;
import com.example.desafio2.model.Room;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PropertyDTO {
    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre de la prop no puede superar los 30 caracteres.")
    private String name;
    private NeighborhoodDTO neighborhood;
    @NotEmpty(message = "La lista de rooms no puede estar vacía.")
    private List<@Valid RoomDTO> rooms;
}
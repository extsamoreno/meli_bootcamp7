package com.example.desafio2.model;

import com.example.desafio2.service.DTO.NeighborhoodDTO;
import com.example.desafio2.service.DTO.RoomDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre de la prop no puede superar los 30 caracteres.")
    private String name;
    private Neighborhood neighborhood;
    @NotEmpty(message = "La lista de rooms no puede estar vacía.")
    private List<Room> rooms;
}
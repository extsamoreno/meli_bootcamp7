package com.desafio.TuCasitaTasacionesApp.model.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Valid
@Getter
@Setter
@AllArgsConstructor
public class PropietyDTO {

    @NotEmpty(message = "El nombre de la propiedad no puede estar vacio")
    @Pattern(message = "El nombre de la propiedad debe comenzar con mayuscula y no poseer numeros ni caracteres", regexp = "^[A-Z].*[a-z]$")
    @Size(min = 1, max = 30, message = "El nombre de la propiedad debe tener 30 caracteres maximo")
    private String name;

    @NotEmpty(message = "El nombre del barrio no puede estar vacio")
    @Size(min = 1, max = 30, message = "El nombre del barrio debe tener 45 caracteres maximo")
    private String neighborhood;

    @NotEmpty(message = "La propiedad debe tener al menos una habitacion")
    @javax.validation.Valid
    private List<RoomDTO> roomList;

    public PropietyDTO() {
        this.roomList = new ArrayList<>();
    }

    public List<RoomDTO> getRoomList() {
        return roomList;
    }
}

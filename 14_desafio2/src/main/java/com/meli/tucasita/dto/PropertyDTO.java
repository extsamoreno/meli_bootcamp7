package com.meli.tucasita.dto;

import com.meli.tucasita.models.Room;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PropertyDTO {

    @NotBlank(message = "El nombre de la propiedad no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la propiedad debe comenzar con mayúscula")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String name;

    @NotBlank(message = "El nombre del barrio no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del barrio debe comenzar con mayúscula")
    @Size(max = 30, message = "La longitud del barrio no puede superar los 45 caracteres")
    private String district;

    @Valid
    private List<RoomDTO> rooms;

}

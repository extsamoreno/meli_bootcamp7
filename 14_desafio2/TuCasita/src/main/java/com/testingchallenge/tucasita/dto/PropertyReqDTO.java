package com.testingchallenge.tucasita.dto;

import com.testingchallenge.tucasita.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyReqDTO {
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la propiedad debe comenzar con mayúscula")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String name;

    @NotEmpty(message = "El barrio no puede estar vacío")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres")
    private String neighborhood;

    @NotNull(message = "La lista de ambientes no puede estar vacía")
    private List<@Valid Room> roomList;
}

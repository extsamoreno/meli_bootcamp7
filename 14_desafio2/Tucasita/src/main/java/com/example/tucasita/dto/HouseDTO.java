package com.example.tucasita.dto;

import com.example.tucasita.domain.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HouseDTO {
    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp = "([A-Z][a-zäÄëËïÏöÖüÜáéíóúáéíóúÁÉÍÓÚÂÊÎÔÛâêîôûàèìòùÀÈÌÒÙ]+[\\p{Space}]*)*", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;
    private @Valid DistrictDTO district;
    private List<@Valid RoomDTO> room;
}

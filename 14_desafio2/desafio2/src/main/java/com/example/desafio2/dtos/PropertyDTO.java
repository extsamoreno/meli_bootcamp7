package com.example.desafio2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {
    @NotBlank(message="El nombre de la propiedad no puede estar vacio.")
    @Pattern(regexp="([A-Z].*)", message="El nombre de la propiedad debe comenzar con mayuscula")
    @Size(max=30, message="La longitud del nombre no puede superar los 30 caracteres.")
    private String name;
    private @Valid DistrictDTO district;
    private List<@Valid RoomDTO> roomList;
}

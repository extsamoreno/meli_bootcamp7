package com.bootcamp.tucasitatasaciones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {

    @NotEmpty(message = "El barrio no puede estar vacío.")
    @Size(max = 30, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String name;
}

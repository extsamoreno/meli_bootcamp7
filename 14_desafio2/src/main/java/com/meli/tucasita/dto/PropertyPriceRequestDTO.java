package com.meli.tucasita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyPriceRequestDTO extends RoomsDTO{

    @NotBlank(message = "El barrio no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del ambiente debe comenzar con mayúscula")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres")
    private String district;

}

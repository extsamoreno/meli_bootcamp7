package com.meli.desafio2.dto.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {

    @NotNull(message = "El id del barrio no puede estar vacio")
    private Integer id;

    @NotEmpty(message = "El nombre del distrito no puede estar vacio")
    @Size(max = 45, message = "La longitud del nombre del distrito no puede superar los 45 caracteres.")
    private String name;

    @NotNull(message = "El precio del barrio no puede estar vacio")
    @DecimalMax(value = "4000.0", message = "El precio por metro cuadrado no puede ser mayor a $4000")
    @DecimalMin(value = "0.0", message = "El precio por metro cuadrado no puede ser menor a $0")
    private Double price;
}

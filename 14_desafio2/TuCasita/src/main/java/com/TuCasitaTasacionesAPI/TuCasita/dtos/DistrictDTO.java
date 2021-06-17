package com.TuCasitaTasacionesAPI.TuCasita.dtos;

import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {

    @NotEmpty(message = "El barrio no puede estar vacío.")
    @Size(min = 1, max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String district_name;

    @NotNull(message = "El precio de un barrio no puede estar vacío.")
    @Min(value = 1, message = "El precio no puede ser menor a 1 U$S")
    @Max(value = 4000, message = "El precio máximo permitido por metro cuadrado no uede superar los 4000 U$S.")
    private Double district_price;
}

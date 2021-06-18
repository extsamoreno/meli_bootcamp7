package com.example.tucasita.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class DistrictDTO {
    @NotBlank(message = "El barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String districtName;

    @NotNull(message = "El precio de un barrio no puede estar vacío.")
    @DecimalMin(value= "0.0", message = "El precio mínimo permitido por metro cuadrado no puede ser menor a los 0 U$S.")
    @DecimalMax(value= "4000.0", message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    private Double districtPrize;
}

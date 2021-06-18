package com.didney.junit.tucasitatasaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {
    @NotNull(message = "El barrio no puede ser nulo.")
    @NotEmpty(message = "El barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la propiedad debe comenzar con mayúscula.")
    private String districtName;
    @NotNull
    @DecimalMin(value = "0", message = "El precio mínimo permitido por metro cuadrado no puede ser inferior o igual a 0 U$S.")
    @DecimalMax(value = "4000", message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    private double districtPrice;
}

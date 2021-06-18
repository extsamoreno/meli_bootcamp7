package meli.bootcamp.tucasita.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DistrictDTO {

    @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String district_name;

    @NotNull(message = "El precio de un barrio no puede estar vacío.")
    @DecimalMax(value ="4000", message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 US$.")
    @DecimalMin(value ="1", message = "El precio minimo permitido por metro cuadrado no puede estar por debajo de 1 US$.")
    private double district_price;

}

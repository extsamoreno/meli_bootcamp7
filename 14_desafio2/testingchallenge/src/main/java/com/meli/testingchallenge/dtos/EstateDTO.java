package com.meli.testingchallenge.dtos;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstateDTO {

    @NotNull(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*",  message ="El nombre de la propiedad debe comenzar con mayúscula.")
    @Size(min = 1, message = "El nombre de la propiedad no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String prop_name;
    @NotNull(message = "El barrio no puede estar vacío.")
    @Size(min = 1, message = "El nombre del barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String district_name;
    @NotNull(message = "El precio de un barrio no puede estar vacío.")
    @DecimalMax(value="4000.0", message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    @DecimalMin(value="1.0", message = "El precio mínimo permitido por metro cuadrado no puede ser inferior a 1 U$S.")
    private double district_price;
    @NotEmpty(message = "Cada propiedad debe tener al menos un ambiente")
    private List<@Valid EnvironmentDTO> environments;

    @Override
    public String toString() {
        return "EstateDTO{" +
                "prop_name='" + prop_name + '\'' +
                ", district_name='" + district_name + '\'' +
                ", district_price=" + district_price +
                ", environments=" + environments +
                '}';
    }
}

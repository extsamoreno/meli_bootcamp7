package com.meli.tuCasita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @NotBlank(message = "El nombre del districto no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
    @Size(max = 45, message = "La longitud del nombre del districto no puede superar los 50 caracteres.")
    @UniqueElements()
    String districtName;

    @Positive( message =" El valor de la propiedad debe ser un numero Positivo")
    @Max(value = 4000, message = "El precio del metro cuadrado no puede superar los 4000 dolares")
    Double pricePerMeter2;
}

package com.example.tucasita.dto;

import lombok.*;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class DistrictDTO {
    @NotBlank(message = "El barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del nombre no puede superar los 45 caracteres.")
    private String name;
    @NotNull(message = "EL precio de un barrio no puede estar vacio")
    @DecimalMax(value = "4000.0", message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    @DecimalMin(value = "0.01", message = "La precio debe ser mayor a 0.0 U$S.")
    private Double price;

}

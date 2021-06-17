package desafio2.testing.service.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {

    @NotNull(message = "El id no puede ser vacio.")
    private Integer id;

    @NotBlank( message = "El barrio no puede estar vacío.")  // not null + not empty string
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres." )
    private String name;

    @NotNull( message = "El barrio no puede estar vacío.")  // not null + not empty string
    @DecimalMin(value = "1.0", message = "El precio mínimo permitido por metro cuadrado no puede ser menor a 0 U$S.")
    @DecimalMax(value = "4000.0", message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    private Double price;
}

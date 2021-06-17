package desafio2.testing.service.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentHouseDTO {
    @NotEmpty( message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*",  message ="El nombre del ambiente debe comenzar con mayúscula." )
    @Size(max = 30, min = 1 , message = "La longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @NotNull( message = "El ancho del ambiente no puede estar vacío.")  // not null + not empty string
    @DecimalMin(value = "1.0" , message = "El mínimo ancho permitido por propiedad es de 1 mts.")
    @DecimalMax(value = "25.0", message = "El máximo ancho permitido por propiedad es de 25 mts.")
    private Double width;

    @NotNull( message = "El largo del ambiente no puede estar vacío.")  // not null + not empty string
    @DecimalMin(value = "1.0", message = "El mínimo ancho permitido por propiedad es de 1 mts.")
    @DecimalMax(value = "33.0", message = "El máximo largo permitido por propiedad es de 33 mts.")
    private Double length;
}

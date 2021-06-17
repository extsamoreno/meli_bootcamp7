package desafio2.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class EnvironmentDTO {
    @NotEmpty(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(message = "El nombre del ambiente debe comenzar con mayúscula.",regexp = "^[A-Z].*")
    @Length(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
    @NotNull(message = "El ancho del ambiente no puede estar vacío.")
    @Max(value = 25,message = "El máximo ancho permitido por propiedad es de 25 mts.")
    double width;
    @NotNull(message = "El largo del ambiente no puede estar vacío.")
    @Max(value = 33,message = "El máximo largo permitido por propiedad es de 33 mts.")
    double length;
}

package desafio2.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class DistrictDTO {
    @NotEmpty(message = "El barrio no puede estar vacío.")
    @Length(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    String name;
    @NotNull(message = "El precio de un barrio no puede estar vacío.")
    @Max(value = 4000, message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
    double price;
}

package desafio2.demo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class PropertyDTO {
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(message = "El nombre de la propiedad debe comenzar con mayúscula.",regexp = "^[A-Z].*")
    @Length(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
}

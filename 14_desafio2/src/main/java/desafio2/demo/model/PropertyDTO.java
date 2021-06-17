package desafio2.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
public class PropertyDTO {
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(message = "El nombre de la propiedad debe comenzar con mayúscula.",regexp = "^[A-Z].*")
    @Length(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
    @Valid
    DistrictDTO district;
    @Valid
    List<EnvironmentDTO> environments;
}

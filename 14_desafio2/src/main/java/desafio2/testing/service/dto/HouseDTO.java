package desafio2.testing.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO {

    @NotNull
    private Integer id;

    @NotBlank( message = "El nombre de la propiedad no puede estar vacío.")  // not null + not empty string
    @Pattern(regexp = "[A-Z].*",  message ="El nombre de la propiedad debe comenzar con mayúscula." )
    @Size(max = 30, min=1, message = "La longitud del nombre no puede superar los 30 caracteres." )
    private String prop_name;

    //@NotEmpty
    private @Valid DistrictDTO district;

    @NotEmpty
    private List<@Valid EnvironmentHouseDTO> environments = new ArrayList<>();

}

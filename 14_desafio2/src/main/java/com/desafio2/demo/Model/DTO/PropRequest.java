package com.desafio2.demo.Model.DTO;

import com.desafio2.demo.Model.Environment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropRequest {

    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    @Pattern(regexp = "[A-ZÀ-ÿ].+", message = "El nombre de la propiedad debe comenzar con mayúscula")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String name;

    @JsonProperty("district")
    @NotEmpty(message = "El barrio no puede estar vacío.")
    @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
    private String districtName;

    private List<@Valid EnvironmentDTO> environments;
}

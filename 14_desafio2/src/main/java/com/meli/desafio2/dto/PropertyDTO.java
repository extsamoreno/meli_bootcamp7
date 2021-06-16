package com.meli.desafio2.dto;

import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {

    @NotNull(message = "El id de la propiedad no puede estar vacio")
    private Integer id;

    @NotEmpty(message = "El nombre de la propiedad no puede estar vacio")
    private String name;

    @NotNull(message = "El id del barrio no puede estar vacio")
    private Integer districtId;

    @NotEmpty(message = "La lista de ambientes no puede estar vacia")
    private List<@Valid Environment> environments;
}

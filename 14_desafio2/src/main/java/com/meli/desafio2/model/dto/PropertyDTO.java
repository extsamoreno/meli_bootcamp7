package com.meli.desafio2.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.desafio2.model.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {

    private String prop_name;
    private double prop_mts2;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double prop_price;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private EnvironmentDTO prop_environment_most_great;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private List<EnvironmentDTO> environmentList;
}

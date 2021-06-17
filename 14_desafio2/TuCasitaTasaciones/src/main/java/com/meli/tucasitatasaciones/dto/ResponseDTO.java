package com.meli.tucasitatasaciones.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
    private Double totalSquareMeters;
    private Double propertyValue;
    private EnvironmentDTO biggestEnvironment;
    private List<EnvironmentDTO> environmentsSquareMeters;
}

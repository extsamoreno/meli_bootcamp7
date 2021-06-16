package com.meli.tucasitatasaciones.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private Double totalSquareMeters;
    private Double propertyPrice;
    private EnvironmentDTO biggerEnvironment;
    private List<EnvironmentDTO> environmentsSquareMeters;

    public ResponseDTO(Double totalSquareMeters) {
        this.totalSquareMeters = totalSquareMeters;
    }
}

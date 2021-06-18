package com.didney.junit.tucasitatasaciones.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentSquareMeterDTOResponse {
    private String environmentName;
    private double totalSquareMeter;
}

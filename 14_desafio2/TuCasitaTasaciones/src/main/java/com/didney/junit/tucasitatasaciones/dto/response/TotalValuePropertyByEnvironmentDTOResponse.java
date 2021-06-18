package com.didney.junit.tucasitatasaciones.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalValuePropertyByEnvironmentDTOResponse {
    private String propertyName;
    private double totalValueProperty;
}

package com.didney.junit.tucasitatasaciones.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalSquareMeterPropertyDTOResponse {
    private String propertyName;
    private double totalMeterSquare;
}

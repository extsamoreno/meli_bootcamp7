package com.tucasitaTasaciones.dto.ResponseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalculateResponseDTO {
    private Integer totalSquareMeters;
    private Double propertyPrice;
    private String largestRoom;
    private Map<String, Integer> environmentsSquareMeters;
}

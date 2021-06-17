package com.tuCasita.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyWithTotalSquareMetersByEnvironmentDTO {
    private String name;
    private DistrictDTO districtDTO;
    private ArrayList<EnvironmentWithTotalSquareMetersDTO> environments;
}

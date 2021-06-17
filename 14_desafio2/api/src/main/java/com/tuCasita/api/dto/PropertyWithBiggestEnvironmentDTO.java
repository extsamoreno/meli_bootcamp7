package com.tuCasita.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyWithBiggestEnvironmentDTO extends PropertyDTO{
    private EnvironmentWithTotalSquareMetersDTO biggestEnvironment;

    public PropertyWithBiggestEnvironmentDTO(String name, DistrictDTO districtDTO, ArrayList<EnvironmentDTO> environmentDTOS, EnvironmentWithTotalSquareMetersDTO biggestEnvironment){
        super(name, districtDTO, environmentDTOS);
        this.biggestEnvironment = biggestEnvironment;
    }
}

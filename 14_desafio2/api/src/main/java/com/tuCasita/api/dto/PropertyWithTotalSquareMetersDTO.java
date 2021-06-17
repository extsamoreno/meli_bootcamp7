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
public class PropertyWithTotalSquareMetersDTO extends PropertyDTO {
    private double totalSquareMeters;

    public PropertyWithTotalSquareMetersDTO(String name, DistrictDTO districtDTO, ArrayList<EnvironmentDTO> environmentDTOS, double total){
        super(name, districtDTO, environmentDTOS);
        this.totalSquareMeters = total;
    }
}

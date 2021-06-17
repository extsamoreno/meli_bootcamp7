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
public class PropertyWithTotalValueDTO extends PropertyDTO{
    private double totalValue;

    public PropertyWithTotalValueDTO(String name, DistrictDTO districtDTO, ArrayList<EnvironmentDTO> environmentDTOS, double total){
        super(name, districtDTO, environmentDTOS);
        this.totalValue = total;
    }
}

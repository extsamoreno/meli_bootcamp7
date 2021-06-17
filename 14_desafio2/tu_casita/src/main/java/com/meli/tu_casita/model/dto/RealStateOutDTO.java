package com.meli.tu_casita.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RealStateOutDTO {

    private Integer id;
    private String name;
    private DistrictDTO districtDTO;
    private List<EnvironmentDTO> environments;
    private float metersTotal;
    private float price;

}

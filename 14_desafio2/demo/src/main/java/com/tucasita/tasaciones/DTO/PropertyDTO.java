package com.tucasita.tasaciones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PropertyDTO {

    private Integer id;
    private String name;
    private DistrictDTO district;
    private List<EnvironmentDTO> listEnvironment;
    private double squareMeters;

    public PropertyDTO() {
        this.listEnvironment = new ArrayList<>();
    }
}

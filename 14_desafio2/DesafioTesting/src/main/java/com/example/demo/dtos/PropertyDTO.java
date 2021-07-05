package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {

    private int prop_id;
    private String prop_name;
    private DistrictDTO district;
    private List<EnvironmentDTO> environments;

}

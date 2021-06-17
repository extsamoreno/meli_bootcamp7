package com.tucasitaTasaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    private Integer propId;
    private String prop_name;
    private District district;
    private List<Environment> environmentList;

}

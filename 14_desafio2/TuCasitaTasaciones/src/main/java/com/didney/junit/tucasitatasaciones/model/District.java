package com.didney.junit.tucasitatasaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {
    private int id;
    private String districtName;
    private double districtPrice;
}

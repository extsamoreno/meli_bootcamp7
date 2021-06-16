package com.tucasitatasaciones.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    private String name;

    private int districtId;

    private Environment environment;
}

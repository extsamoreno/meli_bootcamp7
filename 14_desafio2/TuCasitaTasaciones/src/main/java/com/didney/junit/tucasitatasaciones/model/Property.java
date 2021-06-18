package com.didney.junit.tucasitatasaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    private int id;
    private String propName;
    private District district;
    private List<Environment> environments;
}

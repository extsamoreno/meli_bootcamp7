package com.tucasitatasaciones.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    private int id;
    private String name;
    private int districtId;
    private List<Environment> environments;
}

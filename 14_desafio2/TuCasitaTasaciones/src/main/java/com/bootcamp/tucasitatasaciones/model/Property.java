package com.bootcamp.tucasitatasaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    private Long id;
    private String name;
    private Long districtId;
    private List<Enviroment> enviroments;
}

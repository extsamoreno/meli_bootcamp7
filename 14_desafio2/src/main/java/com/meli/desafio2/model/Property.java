package com.meli.desafio2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    private Integer id;
    private String name;
    private Integer districtId;
    private List<Environment> environments;
}

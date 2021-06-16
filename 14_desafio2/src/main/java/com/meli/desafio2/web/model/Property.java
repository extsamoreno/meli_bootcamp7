package com.meli.desafio2.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    private String prop_name;
    private String district;
    private List<Environment> environments;

}

package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    private int prop_id;
    private String prop_name;
    private District district;
    private List<Environment> environments;

}

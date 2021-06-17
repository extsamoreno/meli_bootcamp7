package com.meli.testingchallenge.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estate {

    private String prop_name;
    private String district_name;
    private List<Environment> environments;

}

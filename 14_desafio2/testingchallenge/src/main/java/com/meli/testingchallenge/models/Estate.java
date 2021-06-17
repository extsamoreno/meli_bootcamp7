package com.meli.testingchallenge.models;

import com.meli.testingchallenge.dtos.EnvironmentDTO;
import com.meli.testingchallenge.dtos.EnvironmentDTORes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estate {

    private String prop_name;
    private String district_name;
    private double district_price;
    private List<Environment> environments;

}

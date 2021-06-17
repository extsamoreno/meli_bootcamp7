package com.example.testing.dto;

import com.example.testing.model.District;
import com.example.testing.model.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {

    private String name;
    private District district;
    private ArrayList<Environment> environments = new ArrayList<>();
    private ArrayList<EnvironmentDTO> environmentDTOS = new ArrayList<>();
    private Environment biggestEnvironment;
    private Double totalSquareMeters;
    private Double price;



}

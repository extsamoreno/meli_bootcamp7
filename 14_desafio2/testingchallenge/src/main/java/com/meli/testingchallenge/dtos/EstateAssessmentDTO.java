package com.meli.testingchallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstateAssessmentDTO {


    private String name;
    private double totalSquareMeters;
    private double totalPrice;
    private EnvironmentDTORes biggerEnvironment;
    private List<EnvironmentDTORes> environmentsSqrMeters;


}

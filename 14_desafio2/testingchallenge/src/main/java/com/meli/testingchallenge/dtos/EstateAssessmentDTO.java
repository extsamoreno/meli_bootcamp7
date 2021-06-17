package com.meli.testingchallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstateAssessmentDTO {


    private String prop_name;
    private double totalSquareMeters;

}

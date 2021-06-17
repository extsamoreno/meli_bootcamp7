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

    public double calculateSurface() {

        return environments.stream()
                .mapToDouble(e -> e.calculateSurface())
                .sum();
    }

    public double calculatePrice(){

        return calculateSurface() * district_price;

    }

    public List<EnvironmentDTORes> generateEnvironmentsCalculations(){

        return environments.stream()
                .map(Environment::generateResponseDto)
                .collect(Collectors.toList());
    }

    public EnvironmentDTORes findBiggerEnvironment(){
        Environment maxEnvironment;
        try{
            maxEnvironment = environments
                    .stream()
                    .max(Comparator.comparing(e -> e.calculateSurface()))
                    .orElseThrow(NoSuchElementException::new);
        } catch(Exception e) {
            return null;
        }
        return maxEnvironment.generateResponseDto();
    }

}

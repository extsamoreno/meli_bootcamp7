package com.tuCasita.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentWithTotalSquareMetersDTO extends EnvironmentDTO{
    private double totalSquareMeters;

    public EnvironmentWithTotalSquareMetersDTO(String name, Double width, Double length, double totalSquareMeters){
        super(name, width, length);
        this.totalSquareMeters = totalSquareMeters;
    }
}

package com.meli.calculatorHouseSquareMeters.model.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
    private String districtName;
    private double squareMeterPrice;
}

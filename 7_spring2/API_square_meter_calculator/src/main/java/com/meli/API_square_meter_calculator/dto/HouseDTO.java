package com.meli.API_square_meter_calculator.dto;

import com.meli.API_square_meter_calculator.entities.Bedroom;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class HouseDTO {
    private String name;
    private ArrayList<BedrommDTO> bedrooms;
}

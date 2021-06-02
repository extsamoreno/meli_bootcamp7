package com.example.Spring2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHouseDTO {

    private House h;
    private double totalM2;
    private double homeValue;
}

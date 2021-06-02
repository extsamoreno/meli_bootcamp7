package com.Spring.clase2.Entities;

import com.Spring.clase2.Entities.House;
import lombok.Data;

@Data
public class ResponseHouseDTO {
    private House house;
    private Double m2;
    private Double price;
}

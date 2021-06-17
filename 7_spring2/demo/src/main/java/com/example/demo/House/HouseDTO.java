package com.example.demo.House;
import lombok.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Getter @Setter
@AllArgsConstructor
public class HouseDTO {
    private double totalArea;
    private double price;
    private String biggestRoom;
    private ArrayList<String> listRoom;
}

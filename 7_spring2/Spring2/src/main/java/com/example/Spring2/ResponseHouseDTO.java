package com.example.Spring2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHouseDTO {

    private String name;
    private double totalM2;
    private double homeValue;
    private Room biggestRoom;
    private ArrayList<ResponseRoomDTO> listRoom;
}

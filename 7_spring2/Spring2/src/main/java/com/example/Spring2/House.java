package com.example.Spring2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {

    private int id;
    private String name;
    private String address;
    private ArrayList<Room> listRoom;

}

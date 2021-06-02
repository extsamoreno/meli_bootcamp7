package com.Spring.clase2.Entities;

import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class House {
    private String name;
    private String address;
    private ArrayList<Room> rooms;


}

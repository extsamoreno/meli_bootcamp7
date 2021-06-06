package com.example.demo.Services;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class House {

    private String name;
    private String address;
    private List<Room> rooms;
    private double price;

}

package com.example.demo.ex1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class HouseDto {


    private String name;
    private String address;
    private ArrayList<RoomDto> rooms;


    public HouseDto() {
        this.rooms = new ArrayList<RoomDto>();
    }
}

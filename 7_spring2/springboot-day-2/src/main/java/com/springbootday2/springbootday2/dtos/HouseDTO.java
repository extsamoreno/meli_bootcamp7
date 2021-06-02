package com.springbootday2.springbootday2.dtos;

import com.springbootday2.springbootday2.entities.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class HouseDTO {
    private int id;
    private String name;
    private String adress;
    private Room[] roomsLst;
    private float meters;
}

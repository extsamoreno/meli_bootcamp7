package com.springbootday2.springbootday2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class House {
    private int id;
    private String name, adress;
    private Room[] roomsLst;
}

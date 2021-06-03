package com.spring2.spring2.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String name;
    private double wide;
    private double large;

    public double getSize(){
        return this.wide * this.large;
    }
}

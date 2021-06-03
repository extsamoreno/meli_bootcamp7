package com.spring2.ejercicios.casa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelRoom {

    private String name;
    private double width;
    private double length;

    public double roomArea(){
        return width*length;
    }
}

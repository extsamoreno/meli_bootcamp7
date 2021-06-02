package com.example.calculadora;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor

public class Room {
    public static final double mtValue = 800.0;

    private double x;
    private double y;
    private String name;

    public Room(){
        this.x = 0.0;
        this.y = 0.0;
    }

    public double getPrice(){

        return this.getMt2()*mtValue;
    }

    public double getMt2(){

        return this.x*this.y;
    }

}

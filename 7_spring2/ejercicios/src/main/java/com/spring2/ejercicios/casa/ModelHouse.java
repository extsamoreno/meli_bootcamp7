package com.spring2.ejercicios.casa;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelHouse {

    private String name;
    private String address;
    private ArrayList<ModelRoom> rooms;

    public double houseArea(){
        double totalArea = 0;
        for (ModelRoom r: rooms) {
            totalArea += r.roomArea();
        }
        return totalArea;
    }

    public double housePrice(){
        double unitPrice = 800;
        return unitPrice * houseArea();
    }

    public ModelRoom biggerRoom(){
        double max = 0;
        ModelRoom rMax = null;
        for (ModelRoom r: rooms) {
            if(r.roomArea() >= max){
                rMax = r;
            }
        }
        return rMax;
    }
}

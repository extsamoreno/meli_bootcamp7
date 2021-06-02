package com.example.calculadora;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private String name;
    private String address;
    private List<Room> rooms;


    public double getPrice(){
        double output = 0.0;
        for (int i = 0; i < this.rooms.size(); i++) {
            output = output + this.rooms.get(i).getPrice();
        }

        return output;
    }

    public Room getBiggestRoom(){
        Room biggestroom = new Room();

        for (int i = 0; i < this.rooms.size(); i++) {
            if(this.rooms.get(i).getMt2() >= biggestroom.getMt2()){
                biggestroom = this.rooms.get(i);
            }
        }

        return biggestroom;
    }
    public double getMt2(){
        Double output = 0.0;

        for (int i = 0; i < this.rooms.size(); i++) {

            output = output + this.rooms.get(i).getMt2();
        }

        return output;
    }
    public HashMap<String,Double> getRooms() {
        HashMap<String,Double> output= new HashMap<String,Double>();

        for (int i = 0; i < this.rooms.size(); i++) {

            output.put(this.rooms.get(i).getName(), this.rooms.get(i).getMt2());
        }

        return output;

    }
}

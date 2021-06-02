package com.example.demo;

import java.util.ArrayList;

public class HouseService {
    public double calculateM2(House house){
        double totalM2=0;
        for (Room r:house.getListRoom()){
            totalM2+=calculateM2Room(r);
        }
        return totalM2;
    }
    public double calculateM2Room(Room room) {
        return room.getHeight()*room.getWidth();
    }
    public double calculatePrice(House house){
        return calculateM2(house)*800;
    }
    public String biggestRoom(House house) {
        double biggestRoom=0;
        String nameRoom="";
        for (int i = 0; i < house.getListRoom().size(); i++) {
            Room room = house.getListRoom().get(i);
            if (this.calculateM2Room(room)>biggestRoom){
                biggestRoom=this.calculateM2Room(room);
                nameRoom=room.getName();
            }
        }
        return "la habitación más grande es "+nameRoom+" con un área de "+biggestRoom;
    }
    public ArrayList<String> roomM2 (House house) {
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<house.getListRoom().size();i++) {
            Room room = house.getListRoom().get(i);
            double area = this.calculateM2Room(room);
            list.add(room.getName()+" "+area);
        }
        return list;
    }
}

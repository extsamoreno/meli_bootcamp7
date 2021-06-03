package SquareMeterCalculator.Core;

import SquareMeterCalculator.Entity.House;
import SquareMeterCalculator.Entity.Rooms;

public class HouseCore {
    public Integer getSqueareMeter(House house) {
        Integer value = 0;
        for (Rooms obj : house.getRooms()) {
            value += obj.getWidth() * obj.getHeight();
        }
        return value;
    }

    public Integer getHousePrice(House house) {
        Integer value = 0;
        for (Rooms obj : house.getRooms()) {
            value += obj.getWidth() * obj.getHeight();
        }
        return value * 800;
    }

    public String getBiggetRoom(House house) {
        String value = "";
        int zise = 0;
        for (Rooms obj : house.getRooms()) {
            if ((obj.getWidth() * obj.getHeight()) > zise) {
                value = obj.getName();
                zise=obj.getWidth() * obj.getHeight();
            }else{
            if ((obj.getWidth() * obj.getHeight()) == zise) {
                value = value+"," + obj.getName();
            }}
        }
        return value;
    }
    public String getSquareMeterRooms(House house) {
        String value = "";
        int cont =0;
        for (Rooms obj : house.getRooms()) {
            cont ++;
                value +="Habitaciòn "+cont+" "+ (obj.getWidth() * obj.getHeight())+",";
        }
        return value;
    }
}

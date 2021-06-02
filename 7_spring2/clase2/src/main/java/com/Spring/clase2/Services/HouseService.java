package com.Spring.clase2.Services;

import com.Spring.clase2.Entities.House;
import com.Spring.clase2.Entities.Room;

public class HouseService {

    public Double calculateM2(House h){
        double tot=0;
        for (Room r: h.getRooms()) {
            tot+= calculateM2Room(r);
        }
        return tot;
    }

    private Double calculateM2Room(Room r){
        return r.getHeight() * r.getWidth();
    }

    public Double calculatePrice(House h, Double priceM2){
        double m2 = calculateM2(h);
        return m2 * priceM2;
    }

    public Room roomBiggest(House h){
        Room roomBiggest = null;
        double maxM2 = 0;

        for (Room r: h.getRooms()) {
            double auxM2 = calculateM2Room(r);
            if(auxM2 > maxM2){
                roomBiggest = r;
                roomBiggest.setM2(auxM2);
                maxM2 = auxM2;
            }
        }

        return roomBiggest;
    }
    public House m2byRoom(House h){
        for (Room r: h.getRooms()) {
            r.setM2(r.getHeight() * r.getWidth());
        }
        return h;
    }
}

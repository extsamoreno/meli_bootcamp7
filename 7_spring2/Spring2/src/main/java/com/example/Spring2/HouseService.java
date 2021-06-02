package com.example.Spring2;

import org.springframework.stereotype.Service;

@Service
public class HouseService {

    public ResponseHouseDTO calculateM2House(House h){

        double totalM2 = 0;

        for (Room r : h.getListRoom()) {
            totalM2 += calculateM2Room(r);
        }

        ResponseHouseDTO rh = new ResponseHouseDTO();
        rh.setH(h);
        rh.setTotalM2(totalM2);
        return rh;
    }

    public Double calculateM2Room(Room r){
        return r.getWidth() * r.getHeight();
    }
}

package com.spring2.ejercicios.casa.dto;

import com.spring2.ejercicios.casa.ModelHouse;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class BiggerRoomDTO {
    private HashMap<String, Double> biggerRoom;

    public BiggerRoomDTO(ModelHouse house) {
        biggerRoom = new HashMap<>();
        String name = house.biggerRoom().getName();
        Double area = house.biggerRoom().roomArea();
        biggerRoom.put(name, area);
    }
}

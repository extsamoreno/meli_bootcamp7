package com.spring2.ejercicios.casa.dto;

import com.spring2.ejercicios.casa.ModelRoom;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
public class RoomsDTO {
    private HashMap<String,Double> rooms;

    public RoomsDTO(ArrayList<ModelRoom> rooms) {
        this.rooms = new HashMap<>();
        for (ModelRoom r : rooms) {
            this.rooms.put(r.getName(), r.roomArea());
        }
    }
}

package com.meli._spring2.dto;

import lombok.Data;

@Data
public class RoomDTO {

    private String name;

    private float length;

    private float width;

    public float getSquareMeters(){
        return  length * width;
    }
}

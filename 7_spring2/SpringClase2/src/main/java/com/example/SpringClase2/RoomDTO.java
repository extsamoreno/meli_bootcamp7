package com.example.SpringClase2;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

@Data
public class RoomDTO {

    private String  name;
    private float   height;
    private float   width;

    public float area(){
        return this.height * this.width;
    }

}

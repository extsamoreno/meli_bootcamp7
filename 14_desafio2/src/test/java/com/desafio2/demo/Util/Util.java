package com.desafio2.demo.Util;

import com.desafio2.demo.Model.DTO.PropRequest;
import com.desafio2.demo.Model.Environment;

import java.util.List;

public class Util {
    public static PropRequest getPropRequest(){
        return new PropRequest("House1", "Villa Prado",
                List.of(new Environment("Kitchen", 4, 3), new Environment("Habitation", 6, 5)));
    }

    public static PropRequest getPropRequestDuplicateDimensions(){
        return new PropRequest("House1", "Villa Prado",
                List.of(new Environment("Kitchen", 4, 3), new Environment("Habitation", 4, 3)));
    }
}

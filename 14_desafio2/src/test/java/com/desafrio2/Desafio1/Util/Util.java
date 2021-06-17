package com.desafrio2.Desafio1.Util;

import com.desafrio2.Desafio1.Model.DTO.PropRequest;
import com.desafrio2.Desafio1.Model.District;
import com.desafrio2.Desafio1.Model.Environment;

import java.util.List;

public class Util {
    public static PropRequest getPropRequest(){
        return new PropRequest("House1", new District("Villa Prado"),
                List.of(new Environment("Kitchen", 4, 3), new Environment("Habitation", 6, 5)));
    }
}

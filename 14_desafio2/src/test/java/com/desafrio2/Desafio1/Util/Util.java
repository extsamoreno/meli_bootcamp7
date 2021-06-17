package com.desafrio2.Desafio1.Util;

import com.desafrio2.Desafio1.Model.DTO.PropRequest;
import com.desafrio2.Desafio1.Model.District;
import com.desafrio2.Desafio1.Model.Environment;

import java.util.List;

public class Util {
    public static PropRequest getPropRequest(){
        return new PropRequest("Casa1", new District("Villa Prado"),
                List.of(new Environment("Cocina", 4, 3), new Environment("Habitacion", 6, 5)));
    }
}

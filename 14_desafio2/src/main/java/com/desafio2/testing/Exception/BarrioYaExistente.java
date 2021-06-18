package com.desafio2.testing.Exception;

import org.springframework.http.HttpStatus;

public class BarrioYaExistente extends PropiedadesException{

    public BarrioYaExistente(String name) {
        super("El barrio: "+name+" ya existe", HttpStatus.BAD_REQUEST);
    }
}

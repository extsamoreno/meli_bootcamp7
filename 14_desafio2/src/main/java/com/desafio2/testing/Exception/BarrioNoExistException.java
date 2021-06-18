package com.desafio2.testing.Exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BarrioNoExistException extends PropiedadesException{

    public BarrioNoExistException(String name) {
        super("El barrio: "+name+" no existe", HttpStatus.BAD_REQUEST);
    }
}

package com.example.demo.service;

import com.example.demo.entity.Turn;
import com.example.demo.repository.ITurnRepository;

public class TurnService implements ITurnService{

    ITurnRepository turnRepository;

    public String addTurn (Turn turn){
        turnRepository.save(turn);
        return "El turno se ha añadido correctamente";
    }

}

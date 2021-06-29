package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Turn;
import com.example.AppConsultorioMySQL.repositories.ITurnRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TurnService implements ITurnService{
    ITurnRepository turnRepository;

    @Override
    public String addTurn(Turn turn) {
        return null;
    }

    @Override
    public String updateTurn(Turn turn) {
        return null;
    }

    @Override
    public String deleteTurn(Turn turn) {
        return null;
    }
}

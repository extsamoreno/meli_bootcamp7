package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Turn;
import com.example.AppConsultorioMySQL.repositories.ITurnRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TurnService implements ITurnService{
    ITurnRepository turnRepository;

    @Override
    public String createTurn(Turn patient) {
        return null;
    }

    @Override
    public String updateTurn(Turn patient) {
        return null;
    }

    @Override
    public String deleteTurn(Long id) {
        return null;
    }

    @Override
    public List<Turn> findAllTurns() {
        return null;
    }

    @Override
    public Turn findTurnById(Long id) {
        return null;
    }
}

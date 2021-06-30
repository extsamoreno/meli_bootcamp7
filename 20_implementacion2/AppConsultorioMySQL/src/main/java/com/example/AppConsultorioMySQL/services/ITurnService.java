package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Turn;

import java.util.List;

public interface ITurnService {
    String createTurn(Turn patient);
    String updateTurn(Turn patient);
    String deleteTurn(Long id);
    List<Turn> findAllTurns();
    Turn findTurnById(Long id);
}

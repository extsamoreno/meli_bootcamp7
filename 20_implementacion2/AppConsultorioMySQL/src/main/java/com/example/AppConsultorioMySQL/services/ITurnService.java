package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Turn;

public interface ITurnService {
    String addTurn(Turn turn);
    String updateTurn(Turn turn);
    String deleteTurn(Turn turn);
}

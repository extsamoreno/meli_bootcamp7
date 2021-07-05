package com.muelitas.demo.services;

import com.muelitas.demo.dtos.TurnDTO;

import java.util.List;

public interface ITurnService {
    void addNewTurn(TurnDTO turn);

    TurnDTO findTurnById(Long id);

    List<TurnDTO> findAllTurns();

    TurnDTO updateTurn(TurnDTO turn);
}

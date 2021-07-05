package com.muelitas.demo.services;

import com.muelitas.demo.dtos.TurnDTO;
import com.muelitas.demo.exceptions.BadRequestException;

import java.util.List;

public interface ITurnService {
    void addNewTurn(TurnDTO turn) throws BadRequestException;

    TurnDTO findTurnById(Long id) throws BadRequestException;

    List<TurnDTO> findAllTurns();

    TurnDTO updateTurn(TurnDTO turn) throws BadRequestException;

    void cancelTurnById(Long id) throws BadRequestException;
}

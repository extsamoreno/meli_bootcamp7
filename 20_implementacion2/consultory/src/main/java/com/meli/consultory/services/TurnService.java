package com.meli.consultory.services;

import com.meli.consultory.models.Turn;

import java.util.List;
import java.util.Optional;

public interface TurnService {

    public void createTurn(Turn turn);

    public void deleteTurn(Turn turn);

    public List<Turn> findAll();

    public Optional<Turn> findById(Long id);

    public void updateTurn(Turn turn);
}

package com.meli.consultory.services;

import com.meli.consultory.models.Turn;
import com.meli.consultory.repositories.TurnRepository;

import java.util.List;
import java.util.Optional;

public class TurnServiceImpl implements TurnService{

    TurnRepository turnRepository;

    public void createTurn(Turn turn) {
        turnRepository.save(turn);
    }

    public void deleteTurn(Turn turn) {
        turnRepository.delete(turn);
    }

    public List<Turn> findAll() {
        return turnRepository.findAll();
    }

    public Optional<Turn> findById(Long id) {
        return turnRepository.findById(id);
    }

    public void updateTurn(Turn turn) {
        turnRepository.save(turn);
    }
}

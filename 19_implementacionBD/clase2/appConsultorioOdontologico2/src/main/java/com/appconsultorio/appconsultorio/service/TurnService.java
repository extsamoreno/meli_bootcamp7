package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Turn;
import com.appconsultorio.appconsultorio.repository.ITurnRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TurnService implements ITurnService {

    ITurnRepository iTurnRepository;

    @Override
    public void createTurn(Turn turn) {
        iTurnRepository.save(turn);
    }

    @Override
    public void updateTurn(Turn turn) {
        iTurnRepository.save(turn);
    }

    @Override
    public void removeTurn(int id) {
        iTurnRepository.deleteById(id);
    }

    @Override
    public List<Turn> getTurn() {
        return iTurnRepository.findAll();
    }
}

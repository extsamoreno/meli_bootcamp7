package com.meli.consultorio.service;

import com.meli.consultorio.dto.response.TurnResponse;
import com.meli.consultorio.model.Turn;
import com.meli.consultorio.repository.ITurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnService implements ITurnService {

    @Autowired
    ITurnRepository iTurnRepository;
    @Override
    public void saveTurn(Turn turn) {
        iTurnRepository.save(turn);
    }

    @Override
    public TurnResponse getTurn(Integer id) {
        return TurnResponseMapper.toResponse(iTurnRepository.findById(id).get());
    }
}

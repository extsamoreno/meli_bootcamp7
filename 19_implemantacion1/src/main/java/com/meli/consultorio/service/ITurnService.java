package com.meli.consultorio.service;

import com.meli.consultorio.dto.response.TurnResponse;
import com.meli.consultorio.model.Turn;

public interface ITurnService {
    void saveTurn(Turn turn);
    TurnResponse getTurn(Integer id);
}

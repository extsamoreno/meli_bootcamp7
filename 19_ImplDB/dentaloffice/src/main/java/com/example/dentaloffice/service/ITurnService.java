package com.example.dentaloffice.service;

import com.example.dentaloffice.model.dto.request.CreateTurnDTO;
import com.example.dentaloffice.model.dto.response.TurnDTO;

import java.util.List;

public interface ITurnService {
    String createTurn(CreateTurnDTO turn);

    List<TurnDTO> getAllTurnsResponse();

    List<TurnDTO> getPatientTurns(String dni);
}

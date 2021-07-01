package com.example.implclase2.service;

import com.example.implclase2.model.dto.RequestCreateTurnDTO;
import com.example.implclase2.model.entity.Turn;

import java.util.List;

public interface ITurnService {
    String createTurn(RequestCreateTurnDTO turn);

    List<Turn> getAllTurns();

    List<Turn> getPatientTurns(String dni);
}

package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.Exceptions.TurnNotFoundException;
import com.example.AppConsultorioMySQL.dtos.PatientDTO;
import com.example.AppConsultorioMySQL.dtos.TurnDTO;
import com.example.AppConsultorioMySQL.models.entities.Turn;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface ITurnService {
    String createTurn(TurnDTO turn);
    String updateTurn(TurnDTO turn) throws TurnNotFoundException;
    String deleteTurn(Long id) throws TurnNotFoundException;
    List<TurnDTO> findAllTurns();
    TurnDTO findTurnById(Long id) throws TurnNotFoundException;

    List<TurnDTO> listTurnsStateEnd ();
    List<TurnDTO> listTurnsStatePendingByDate (@PathVariable LocalDate date);
}

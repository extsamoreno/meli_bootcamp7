package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.dto.RegisterTurnDTO;
import com.bootcamp.appconsultoriomysql.dto.TurnDTO;

import java.time.LocalDate;
import java.util.Set;

public interface ITurnService {

    TurnDTO findById(Long id);

    void registerTurn(RegisterTurnDTO turn);

    void deleteById(Long id);

    Set<TurnDTO> findAllFinalized();

    Set<TurnDTO> findAllEarringOnDay(LocalDate day);

    Set<TurnDTO> findAllReprogrammed();

}

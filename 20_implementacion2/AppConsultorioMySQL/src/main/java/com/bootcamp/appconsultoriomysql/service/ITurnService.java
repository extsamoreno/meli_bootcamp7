package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.dto.TurnDTO;

import java.time.LocalDate;
import java.util.Set;

public interface ITurnService {
    Set<TurnDTO> findAllFinalized();

    Set<TurnDTO> findAllEarringOnDay(LocalDate day);

    Set<TurnDTO> findAllReprogrammed();
}

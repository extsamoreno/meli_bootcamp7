package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.dto.ProfessionalDTO;
import com.bootcamp.appconsultoriomysql.dto.TurnDTO;


import java.time.LocalDateTime;
import java.util.Set;

public interface IProfessionalService {
    Set<ProfessionalDTO> findAllWithMoreThanTwoTurnsOnDay(LocalDateTime day);

    Set<TurnDTO> getSchedule(Long id);

    Set<TurnDTO> getReprogrammedTurns(Long id);
}

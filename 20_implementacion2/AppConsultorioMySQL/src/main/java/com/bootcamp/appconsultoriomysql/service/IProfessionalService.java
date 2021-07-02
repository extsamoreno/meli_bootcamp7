package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.dto.TurnDTO;
import com.bootcamp.appconsultoriomysql.model.Professional;
import com.bootcamp.appconsultoriomysql.model.Turn;

import java.time.LocalDateTime;
import java.util.Set;

public interface IProfessionalService {

    Set<Professional> findAllWithMoreThanTwoTurnsOnDay(LocalDateTime day);

    Set<TurnDTO> getSchedule(Long id);
}

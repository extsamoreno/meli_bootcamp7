package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.model.Turn;

import java.time.LocalDate;
import java.util.Set;

public interface ITurnService {

    Set<Turn> findAllFinalized();

    Set<Turn> findAllEarringOnDay(LocalDate day);

    Turn findById(Long id);
}

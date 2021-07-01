package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.model.Professional;

import java.time.LocalDateTime;
import java.util.Set;

public interface IProfessionalService {

    Set<Professional> findAllWithMoreThanTwoTurnsOnDay(LocalDateTime day);
}

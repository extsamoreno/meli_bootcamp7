package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.dto.PatientDTO;

import java.time.LocalDateTime;
import java.util.Set;

public interface IPatientService {
    Set<PatientDTO> findAllByTurnsInDay(LocalDateTime date);
}

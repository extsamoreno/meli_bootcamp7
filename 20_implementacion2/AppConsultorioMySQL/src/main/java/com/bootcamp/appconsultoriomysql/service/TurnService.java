package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.model.Turn;
import com.bootcamp.appconsultoriomysql.repository.ITurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class TurnService implements ITurnService{

    @Autowired
    private ITurnRepository turnRepository;

    @Override
    public Set<Turn> findAllFinalized() {
        return turnRepository.findAllFinalized();
    }

    @Override
    public Set<Turn> findAllEarringOnDay(LocalDate date) {
        return turnRepository.findAllEarringOnDay(date);
    }
}

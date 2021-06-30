package com.example.mongodbexample.service;


import com.example.mongodbexample.domain.Turns;
import com.example.mongodbexample.repository.TurnsRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TurnsService {

    private final TurnsRepository turnsRepository;

    public TurnsService(TurnsRepository turnsRepository) {
        this.turnsRepository = turnsRepository;
    }


    public List<Turns> findAllTurns()  {
        return turnsRepository.findAll();
    }

    public List<Turns>  listsAgenda(String dentist) {
        return turnsRepository.listsAgenda(dentist);
    }

    public List<Turns>  listsAgendaBystatus(String status) {
        return turnsRepository.listsAgendaBystatus(status);
    }

}

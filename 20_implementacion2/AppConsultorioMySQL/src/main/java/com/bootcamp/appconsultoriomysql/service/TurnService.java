package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.dto.TurnDTO;
import com.bootcamp.appconsultoriomysql.model.Turn;
import com.bootcamp.appconsultoriomysql.repository.ITurnRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TurnService implements ITurnService{

    @Autowired
    private ITurnRepository turnRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public Set<TurnDTO> findAllFinalized() {
        Set<Turn> turns = turnRepository.findAllFinalized();

        return turns.stream().map(t -> mapper.map(t, TurnDTO.class)).collect(Collectors.toSet());
    }


    @Override
    @Transactional
    public Set<TurnDTO> findAllEarringOnDay(LocalDate date) {
        Set<Turn> turns = turnRepository.findAllEarringOnDay(date);

        return turns.stream().map(t -> mapper.map(t, TurnDTO.class)).collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public Set<TurnDTO> findAllReprogrammed() {
        Set<Turn> turns = turnRepository.findAllReprogrammed();

        return turns.stream().map(t -> mapper.map(t, TurnDTO.class)).collect(Collectors.toSet());
    }
}

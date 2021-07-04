package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.dto.ProfessionalDTO;
import com.bootcamp.appconsultoriomysql.dto.TurnDTO;
import com.bootcamp.appconsultoriomysql.model.Professional;
import com.bootcamp.appconsultoriomysql.model.Turn;
import com.bootcamp.appconsultoriomysql.repository.IProfessionalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProfessionalService implements IProfessionalService{

    @Autowired
    private IProfessionalRepository professionalRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Set<ProfessionalDTO> findAllWithMoreThanTwoTurnsOnDay(LocalDateTime day) {

        Set<Professional> professionals = professionalRepository.findAllWithMoreThanTwoTurnsOnDay(day);

        return professionals.stream().map(p -> mapper.map(p, ProfessionalDTO.class)).collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public Set<TurnDTO> getSchedule(Long id) {

        Set<Turn> turns = professionalRepository.getSchedule(id);

        return turns.stream().map((t) -> mapper.map(t, TurnDTO.class)).collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public Set<TurnDTO> getReprogrammedTurns(Long id) {

        Set<Turn> turns = professionalRepository.getReprogrammedTurns(id);

        return turns.stream().map((t) -> mapper.map(t, TurnDTO.class)).collect(Collectors.toSet());
    }
}

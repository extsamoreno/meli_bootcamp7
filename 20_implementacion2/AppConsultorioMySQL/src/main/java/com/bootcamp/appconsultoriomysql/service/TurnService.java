package com.bootcamp.appconsultoriomysql.service;

import com.bootcamp.appconsultoriomysql.dto.RegisterTurnDTO;
import com.bootcamp.appconsultoriomysql.dto.TurnDTO;
import com.bootcamp.appconsultoriomysql.model.Patient;
import com.bootcamp.appconsultoriomysql.model.Professional;
import com.bootcamp.appconsultoriomysql.model.Turn;
import com.bootcamp.appconsultoriomysql.model.TurnStatus;
import com.bootcamp.appconsultoriomysql.repository.IPatientRepository;
import com.bootcamp.appconsultoriomysql.repository.IProfessionalRepository;
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
    private IPatientRepository patientRepository;

    @Autowired
    private IProfessionalRepository professionalRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public TurnDTO findById(Long id) {
        Turn turn = turnRepository.findById(id).orElse(null);

        TurnDTO turnDTO = mapper.map(turn, TurnDTO.class);

        return turnDTO;
    }

    @Override
    @Transactional
    public void registerTurn(RegisterTurnDTO registerTurnDTO) {
        Patient patient = patientRepository.findById(registerTurnDTO.getPatientId()).orElse(null);
        if (patient == null) {
            //Throw exception
        }

        Professional professional = professionalRepository.findById(registerTurnDTO.getProfessionalId()).orElse(null);
        if (professional == null) {
            //Throw exception
        }

        Turn turn = new Turn();
        turn.setDateStart(registerTurnDTO.getDateStart());
        turn.setDateEnd(registerTurnDTO.getDateEnd());
        turn.setPatient(patient);
        turn.setProfessional(professional);
        turn.setStatus(TurnStatus.EARRING);

        turnRepository.save(turn);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        turnRepository.deleteById(id);
    }

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

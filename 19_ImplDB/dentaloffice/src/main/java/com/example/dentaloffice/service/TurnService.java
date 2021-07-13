package com.example.dentaloffice.service;

import com.example.dentaloffice.model.dto.request.CreateTurnDTO;
import com.example.dentaloffice.model.dto.response.TurnDTO;
import com.example.dentaloffice.model.entity.Dentist;
import com.example.dentaloffice.model.entity.Patient;
import com.example.dentaloffice.model.entity.Turn;
import com.example.dentaloffice.repository.IDentistRepository;
import com.example.dentaloffice.repository.IPatientRepository;
import com.example.dentaloffice.repository.ITurnRepository;
import com.example.dentaloffice.service.mapper.IMyMapper;
import com.example.dentaloffice.service.util.TurnUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TurnService implements ITurnService{

    // Inyected by constructor
    ITurnRepository iTurnRepository;
    IDentistRepository iDentistRepository;
    IPatientRepository iPatientRepository;
    IMyMapper iMyMapper;

    @Override
    @Transactional
    public String createTurn(CreateTurnDTO turn) {
        Dentist dentist = iDentistRepository.findDentistByDni(turn.getDentistDni());
        Patient patient = iPatientRepository.findPatientByDni(turn.getPatientDni());
        Turn newTurn = new Turn();
        newTurn.setDatetime(TurnUtils.toDate(turn.getDate()));
        newTurn.setDentist(dentist);
        newTurn.setPatient(patient);
        iTurnRepository.save(newTurn);
        return "Turn created successfully";
    }

    @Override
    public List<TurnDTO> getAllTurnsResponse() {
        return iTurnRepository.findAll()
                .stream()
                .map(turn -> iMyMapper.toTurnDTO(turn))
                .collect(Collectors.toList());
    }

    @Override
    public List<TurnDTO> getPatientTurns(String dni) {
        return iTurnRepository.findTurnByPatientDni(dni)
                .stream()
                .map(turn -> iMyMapper.toTurnDTO(turn))
                .collect(Collectors.toList());
    }

}

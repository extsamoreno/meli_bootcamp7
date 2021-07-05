package com.muelitas.demo.services;

import com.muelitas.demo.dtos.StatusDTO;
import com.muelitas.demo.dtos.TurnDTO;
import com.muelitas.demo.exceptions.BadRequestException;
import com.muelitas.demo.models.Dentist;
import com.muelitas.demo.models.Patient;
import com.muelitas.demo.models.Turn;
import com.muelitas.demo.repositories.IDentistRepository;
import com.muelitas.demo.repositories.IPatientRepository;
import com.muelitas.demo.repositories.ITurnRepository;
import com.muelitas.demo.services.enums.StatusEnum;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TurnService implements ITurnService{

    private ITurnRepository turnRepository;
    private IDentistRepository dentistRepository;
    private IPatientRepository patientRepository;
    private ModelMapper mapper;

    @Override
    public void addNewTurn(TurnDTO turn) throws BadRequestException {
        validateDentistAndPacientExist(turn);

        turn.setEndDate(turn.getStartDate().plusMinutes(30));
        turn.setStatusId(StatusEnum.PENDING.getValue());
        Turn turnToAdd = mapper.map(turn, Turn.class);
        Turn turnAdded = turnRepository.save(turnToAdd);
    }

    @Override
    public TurnDTO findTurnById(Long id) throws BadRequestException {
        return validateTurn(id);
    }

    @Override
    public List<TurnDTO> findAllTurns() {
        List<Turn> turns = turnRepository.findAllTurns();
        return turns.stream().map(t -> mapper.map(t, TurnDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TurnDTO updateTurn(TurnDTO turn) throws BadRequestException {
        validateTurn(turn.getId());
        validateDentistAndPacientExist(turn);
        Turn turnToUpdate = mapper.map(turn, Turn.class);
        return mapper.map(turnRepository.save(turnToUpdate), TurnDTO.class);
    }

    @Override
    public void cancelTurnById(Long id) throws BadRequestException {
        validateTurn(id);
        turnRepository.cancelTurnById(id);
    }

    private void validateDentistAndPacientExist(TurnDTO turn) throws BadRequestException {
        Optional<Patient> patient = patientRepository.findPatientByIdWithoutLowDate(turn.getPatientId());
        Optional<Dentist> dentist = dentistRepository.findPatientByIdWithoutLowDate(turn.getDentistId());

        if(!patient.isPresent()){
            throw new BadRequestException("El paciente con el id ingresado no existe.");
        }

        if(!dentist.isPresent()){
            throw new BadRequestException("El dentista con el id ingresado no existe.");
        }

        if(turn.getStartDate().isBefore(LocalDateTime.now())){
            throw new BadRequestException("El turno debe ser agendado con fecha posterior a hoy.");
        }
    }

    private TurnDTO validateTurn(Long id) throws BadRequestException {
        if(id <= 0)
            throw new BadRequestException("El id de turno es invalido.");

        Optional<Turn> turn = turnRepository.findById(id);

        if(!turn.isPresent()){
            throw new BadRequestException("El turno con el id ingresado no existe");
        }
        TurnDTO turnDTO = mapper.map(turn.get(), TurnDTO.class);
        return turnDTO;
    }
}

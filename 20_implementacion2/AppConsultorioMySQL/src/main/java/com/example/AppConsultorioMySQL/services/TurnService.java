package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.Exceptions.TurnNotFoundException;
import com.example.AppConsultorioMySQL.dtos.DentistDTO;
import com.example.AppConsultorioMySQL.dtos.PatientDTO;
import com.example.AppConsultorioMySQL.dtos.TurnDTO;
import com.example.AppConsultorioMySQL.models.entities.Dentist;
import com.example.AppConsultorioMySQL.models.entities.Patient;
import com.example.AppConsultorioMySQL.models.entities.Schedule;
import com.example.AppConsultorioMySQL.models.entities.Turn;
import com.example.AppConsultorioMySQL.repositories.IPatientRepository;
import com.example.AppConsultorioMySQL.repositories.IScheduleRepository;
import com.example.AppConsultorioMySQL.repositories.ITurnRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TurnService implements ITurnService{
    ITurnRepository turnRepository;
    IScheduleRepository scheduleRepository;
    IPatientRepository patientRepository;
    ModelMapper mapper;

    @Override
    public String createTurn(TurnDTO turnDTO) {
        Optional<Schedule> scheduleItem = scheduleRepository.findById(turnDTO.getScheduleId());
        Optional<Patient> patientItem = patientRepository.findById(turnDTO.getPatientId());

        if(scheduleItem.isPresent() && patientItem.isPresent()) {
            Turn turn = mapper.map(turnDTO, Turn.class);
            turn.setSchedule(scheduleItem.get());
            turn.setPatient(patientItem.get());

            turnRepository.save(turn);

            return "Se creó el turno correctamente";
        } else {
            return "La agenda y/o el paciente ingresado no se encuentra";
        }
    }

    @Override
    public String updateTurn(TurnDTO turnDTO) throws TurnNotFoundException {
        Optional<Turn> item = turnRepository.findById(turnDTO.getId());

        if (item == null){
            throw new TurnNotFoundException(item);
        }

        turnRepository.saveAndFlush(mapper.map(turnDTO, Turn.class));
        return "Se Actualizó correctamente el turno " + turnDTO.getId();
    }

    @Override
    public String deleteTurn(Long id) throws TurnNotFoundException {
        Optional<Turn> item = turnRepository.findById(id);

        if (item == null){
            throw new TurnNotFoundException(item);
        }

        turnRepository.deleteById(id);

        return "Se eliminó correctamente el turno " + id;
    }

    @Override
    public List<TurnDTO> findAllTurns() {
        List<Turn> turns = turnRepository.findAll();

        return turns.stream().map(turn -> mapper.map(turn, TurnDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TurnDTO findTurnById(Long id) throws TurnNotFoundException {
        Optional<Turn> item = turnRepository.findById(id);

        if (item == null){
            throw new TurnNotFoundException(item);
        }

        return item.map(turn -> mapper.map(turn, TurnDTO.class)).orElse(null);
    }

    @Override
    public List<TurnDTO> listTurnsStateEnd() {
        List<Turn> item = turnRepository.listTurnsStateEnd();
        return item.stream().map(turn -> mapper.map(turn,TurnDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TurnDTO> listTurnsStatePendingByDate(LocalDate date) {
        List<Turn> item = turnRepository.listTurnsStatePendingByDate(date);
        return item.stream().map(turn -> mapper.map(turn,TurnDTO.class)).collect(Collectors.toList());
    }
}

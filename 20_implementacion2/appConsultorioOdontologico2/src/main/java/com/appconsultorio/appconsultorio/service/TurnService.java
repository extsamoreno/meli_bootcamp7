package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.TurnDTO;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.model.Patient;
import com.appconsultorio.appconsultorio.model.Turn;
import com.appconsultorio.appconsultorio.repository.IDentistRepository;
import com.appconsultorio.appconsultorio.repository.IPatientRepository;
import com.appconsultorio.appconsultorio.repository.ITurnRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class TurnService implements ITurnService {

    ITurnRepository iTurnRepository;

    IPatientRepository iPatientRepository;

    IDentistRepository iDentistRepository;

    @Override
    public void createTurn(TurnDTO turnDTO) throws Exception{

        if(turnDTO.getStatus().equals("Reprogramado")) turnDTO = createReprogramedTurn(turnDTO);

        Patient patient = iPatientRepository.findById(turnDTO.getIdPatient()).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        Turn turn = new Turn();
        Set<Dentist> dentists = new HashSet<>();//Collections.emptySet() -> Si pongo esto no puedo agregar optionals
        Optional<Dentist> dentist = Optional.empty();

        turn.setDescription(turnDTO.getDescription());
        turn.setStatus(turnDTO.getStatus());
        if(turnDTO.getIdToReprogTurn() != null) turn.setIdToReprogTurn(turnDTO.getIdToReprogTurn());
        if(!saveTurnTime(turnDTO.getStartTime())) throw new RuntimeException("Turno no disponible");

        turn.setStartTime(turnDTO.getStartTime());
        turn.setStartTime(turnDTO.getStartTime());
        turn.setPatient(patient);

        turnDTO.getIdDentist().forEach(a ->
                dentists.add(iDentistRepository.findById(a).get()));

        dentists.forEach(b -> b.getCalendars().createTurn(turn.getStartTime()));

        turn.setDentistset(dentists);
        iTurnRepository.save(turn);
    }

    private boolean saveTurnTime(LocalDateTime startDate){
        boolean res = false;
        long minutes = startDate.getMinute();
        if(minutes == 30 || minutes == 0) res = true;
        return res;
    }


    private TurnDTO createReprogramedTurn(TurnDTO turnDTO) throws Exception{
        Turn turn = iTurnRepository.findById(turnDTO.getIdToReprogTurn()).orElseThrow(() -> new RuntimeException("Turno no encontrado"));
        changeStatusOfTurn(turn, "Reprogramado");
        if(turn.getStartTime().compareTo(turnDTO.getStartTime()) == 0) throw new RuntimeException("El horario de la reprogramacion no puede ser el mismo que el original");
        return new TurnDTO(
                turn.getDescription(),
                "Pendiente",
                turnDTO.getIdToReprogTurn(),
                turnDTO.getStartTime(),
                turnDTO.getIdPatient(),
                turnDTO.getIdDentist());
    }

    private void changeStatusOfTurn(Turn turn, String status){
        turn.setStatus(status);
        iTurnRepository.save(turn);
    }

    @Override
    public void updateTurn(Turn turn) {
        iTurnRepository.save(turn);
    }

    @Override
    public void removeTurn(int id) {
        iTurnRepository.deleteById(id);
    }

    @Override
    public List<Turn> getTurn() {
        return iTurnRepository.findAll();
    }

    public List<Turn> findTurnosLikeFinalizado(){
        return iTurnRepository.findTurnosLikeFinalizado();
    }

    public List<Turn> findTurnosLikeReprogramed(){return iTurnRepository.findTurnosLikeReprogramed();}
}

package com.example.implclase2.service;

import com.example.implclase2.model.dto.RequestCreateTurnDTO;
import com.example.implclase2.model.entity.Dentist;
import com.example.implclase2.model.entity.Patient;
import com.example.implclase2.model.entity.Turn;
import com.example.implclase2.repository.IDentistRepository;
import com.example.implclase2.repository.IPatientRepository;
import com.example.implclase2.repository.ITurnRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TurnService implements ITurnService{

    ITurnRepository iTurnRepository;
    IDentistRepository iDentistRepository;
    IPatientRepository iPatientRepository;

    @Override
    @Transactional
    public String createTurn(RequestCreateTurnDTO turn) {
        Dentist dentist = iDentistRepository.findDentistByDni(turn.getDentistDni());
        Patient patient = iPatientRepository.findPatientByDni(turn.getPatientDni());
        Turn newTurn = new Turn();
        newTurn.setDatetime(toDate(turn.getDate()));
        newTurn.setDentist(dentist);
        newTurn.setPatient(patient);
        iTurnRepository.save(newTurn);
        return "Turn created successfully";
    }

    @Override
    public List<Turn> getAllTurns() {
        return iTurnRepository.findAll();
    }

    @Override
    public List<Turn> getPatientTurns(String dni) {
        return iTurnRepository.findTurnByPatientDni(dni);
    }

    private static Date toDate(String dateDto)
    {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = inputFormat.parse(dateDto);
        }
        catch (ParseException ex){
            ex.printStackTrace();
        }
        return date;
    }
}

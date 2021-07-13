package com.example.dentaloffice.service.mapper;

import com.example.dentaloffice.model.dto.response.DentistDTO;
import com.example.dentaloffice.model.dto.response.PatientDTO;
import com.example.dentaloffice.model.dto.response.TurnDTO;
import com.example.dentaloffice.model.entity.Dentist;
import com.example.dentaloffice.model.entity.Patient;
import com.example.dentaloffice.model.entity.Turn;
import org.springframework.stereotype.Component;

@Component
public class MyMapper implements IMyMapper{
    @Override
    public TurnDTO toTurnDTO(Turn turn)
    {
        String date = turn.getDatetime().toString();
        String dentistFullName = toDentistDTO(turn.getDentist()).getFullName();
        String patientFullName = toPatientDTO(turn.getPatient()).getFullName();
        return new TurnDTO(date, dentistFullName, patientFullName);
    }

    @Override
    public DentistDTO toDentistDTO(Dentist d) {
        String fullName = d.getName() + " " + d.getSurname();
        return new DentistDTO(fullName, d.getDni());
    }

    @Override
    public PatientDTO toPatientDTO(Patient p) {
        String fullName = p.getName() + " " + p.getSurname();
        return new PatientDTO(fullName, p.getDni());
    }

}

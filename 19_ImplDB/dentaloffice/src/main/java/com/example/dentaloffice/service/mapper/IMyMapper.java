package com.example.dentaloffice.service.mapper;

import com.example.dentaloffice.model.dto.response.DentistDTO;
import com.example.dentaloffice.model.dto.response.PatientDTO;
import com.example.dentaloffice.model.dto.response.TurnDTO;
import com.example.dentaloffice.model.entity.Dentist;
import com.example.dentaloffice.model.entity.Patient;
import com.example.dentaloffice.model.entity.Turn;

public interface IMyMapper {
    TurnDTO toTurnDTO(Turn turn);

    DentistDTO toDentistDTO(Dentist d);

    PatientDTO toPatientDTO(Patient p);
}

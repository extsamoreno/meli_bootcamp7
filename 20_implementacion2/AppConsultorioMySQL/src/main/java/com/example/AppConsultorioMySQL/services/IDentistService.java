package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.Exceptions.DentistNotFoundException;
import com.example.AppConsultorioMySQL.dtos.DentistDTO;

import java.time.LocalDate;
import java.util.List;

public interface IDentistService {
    String createDentist(DentistDTO dentist);
    String updateDentist(DentistDTO dentist) throws DentistNotFoundException;
    String deleteDentist(Long id) throws DentistNotFoundException;
    List<DentistDTO> findAllDentists();
    DentistDTO findDentistById(Long id) throws DentistNotFoundException;

    List<DentistDTO> listDentistMoreThan2TurnsByDate (LocalDate date);
}

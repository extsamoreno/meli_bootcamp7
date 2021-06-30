package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.Exceptions.DentistNotFoundException;
import com.example.AppConsultorioMySQL.models.entities.Dentist;

import java.util.List;

public interface IDentistService {
    String createDentist(Dentist dentist);
    String updateDentist(Dentist dentist) throws DentistNotFoundException;
    String deleteDentist(Long id) throws DentistNotFoundException;
    List<Dentist> findAllDentists();
    Dentist findDentistById(Long id) throws DentistNotFoundException;
}

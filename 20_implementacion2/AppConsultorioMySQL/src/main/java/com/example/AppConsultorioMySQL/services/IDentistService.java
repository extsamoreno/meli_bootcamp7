package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Dentist;

import java.util.List;

public interface IDentistService {
    String createDentist(Dentist dentist);
    String updateDentist(Dentist dentist);
    String deleteDentist(Long id);
    List<Dentist> findAllDentists();
    Dentist findDentistById(Long id);
}

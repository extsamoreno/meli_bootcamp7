package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Dentist;

public interface IDentistService {
    String addDentist(Dentist dentist);
    String updateDentist(Dentist dentist);
    String deleteDentist(Long id);
}

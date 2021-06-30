package com.consultorio.AppConsultorioMySQL.service;

import com.consultorio.AppConsultorioMySQL.model.Dentist;
import org.springframework.stereotype.Service;

@Service
public interface IDentistService {
    void createDentist(Dentist dentist);
    void updateDentist(Dentist dentist);
    void deleteDentist(Dentist dentist);
}

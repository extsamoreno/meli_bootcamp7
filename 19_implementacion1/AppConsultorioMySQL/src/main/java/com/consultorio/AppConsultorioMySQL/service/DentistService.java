package com.consultorio.AppConsultorioMySQL.service;

import com.consultorio.AppConsultorioMySQL.model.Dentist;
import com.consultorio.AppConsultorioMySQL.repository.IDentistRepository;
import org.springframework.stereotype.Service;

@Service
public class DentistService implements IDentistService{
    IDentistRepository iDentistRepository;
    @Override
    public void createDentist(Dentist dentist) {
        iDentistRepository.save(dentist);

    }

    @Override
    public void updateDentist(Dentist dentist) {
    }

    @Override
    public void deleteDentist(Dentist dentist) {
        iDentistRepository.delete(dentist);

    }
}

package com.meli.consultorio.services;

import com.meli.consultorio.models.Dentist;

import java.util.List;

public interface IDentistService {
    void createDentist(Dentist dentist);
    void deleteDentistById(Long id);
    void updateDentist(Dentist dentist);
    List<Dentist> findAllDentists();
    Dentist findDentistById(Long id);
}

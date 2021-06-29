package com.example.app_consultorio.service;

import com.example.app_consultorio.model.Dentist;

import java.util.List;

public interface IDentistService {

    void createDentist(Dentist dentist);
    void deleteDentistById(Long id);
    void updateDentist(Dentist dentist);
    List<Dentist> findAllDentists();
    Dentist findDentistById(Long id);
}

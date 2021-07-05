package com.example.app_consultorio.service;

import com.example.app_consultorio.dto.DentistDTO;
import com.example.app_consultorio.dto.PatientDTO;
import com.example.app_consultorio.model.Dentist;

import java.time.LocalDate;
import java.util.List;

public interface IDentistService {

    void createDentist(Dentist dentist);
    void deleteDentistById(Long id);
    void updateDentist(Dentist dentist);
    List<DentistDTO> findAllDentists();
    Dentist findDentistById(Long id);
    List<DentistDTO> findByAppGreaterThanTwo(String date);
}

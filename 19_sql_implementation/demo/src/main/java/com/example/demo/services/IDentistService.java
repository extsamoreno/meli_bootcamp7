package com.example.demo.services;

import com.example.demo.exceptions.DentistNotFoundException;
import com.example.demo.model.Dentist;
import com.example.demo.services.dtos.AppointmentDTO;
import com.example.demo.services.dtos.DentistDTO;

import java.util.Date;
import java.util.List;

public interface IDentistService {
    void createDentist(Dentist dentist);

    void deleteDentistById(Long id);

    void updateDentist(Dentist dentist);

    List<Dentist> findAllDentists();

    DentistDTO findDentistById(Long id) throws DentistNotFoundException;

    List<DentistDTO> getDentistWithMoreTowAppoiments(Date date);

    List<AppointmentDTO> getDentistDairy(Long id) throws DentistNotFoundException;

}

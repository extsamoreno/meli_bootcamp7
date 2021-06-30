package com.example.demo.service;

import com.example.demo.dto.DentistDTO;
import com.example.demo.entity.Dentist;

public interface IDentistService {

    String addDentist(Dentist dentist);
    String updateDentist(Dentist dentist);
    String deleteDentist(Long id);
    DentistDTO retrieveDentist(Long id);
}

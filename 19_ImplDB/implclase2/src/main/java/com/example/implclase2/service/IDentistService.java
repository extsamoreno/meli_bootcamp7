package com.example.implclase2.service;

import com.example.implclase2.model.dto.RequestCreateDentistDTO;
import com.example.implclase2.model.entity.Dentist;

import java.util.List;

public interface IDentistService {
    String createDentist(RequestCreateDentistDTO patient);

    List<Dentist> getAllDentists();
}

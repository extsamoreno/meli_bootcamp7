package com.example.dentaloffice.service;

import com.example.dentaloffice.model.dto.request.CreateDentistDTO;
import com.example.dentaloffice.model.dto.response.DentistDTO;

import java.util.List;

public interface IDentistService {
    String createDentist(CreateDentistDTO patient);

    List<DentistDTO> getAllDentists();
}

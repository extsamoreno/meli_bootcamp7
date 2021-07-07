package com.meli.muelitas.service;

import com.meli.muelitas.dto.DentistDTO;
import com.meli.muelitas.dto.DentistInDTO;

import java.util.List;

public interface IDentistService {

    void createDentist(DentistInDTO dentistInDTO);

    List<DentistDTO> getDentistList();

    DentistDTO getDentistById(Long id);

    DentistDTO getDentistByName(String name);

}

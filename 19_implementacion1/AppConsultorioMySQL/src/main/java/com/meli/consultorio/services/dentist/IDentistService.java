package com.meli.consultorio.services.dentist;

import com.meli.consultorio.models.dtos.DentistDTO;

import java.util.Set;

public interface IDentistService {
    void createDentist(DentistDTO dentist);
    void deleteDentistById(Long id);
    void updateDentist(DentistDTO dentist);
    Set<DentistDTO> findAllDentists();
    DentistDTO findDentistById(Long id);
}

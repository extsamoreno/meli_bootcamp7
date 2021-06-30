package com.meli.consultorio.services.dentist;

import com.meli.consultorio.models.dtos.DentistDTO;

import java.util.List;

public interface IDentistService {
    void createDentist(DentistDTO dentist);
    void deleteDentistById(Long id);
    void updateDentist(DentistDTO dentist);
    List<DentistDTO> findAllDentists();
    DentistDTO findDentistById(Long id);
}

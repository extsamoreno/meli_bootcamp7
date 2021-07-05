package com.muelitas.demo.services;

import com.muelitas.demo.dtos.DentistDTO;
import com.muelitas.demo.exceptions.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDentistService {
    void saveDentist(DentistDTO dentist);
    DentistDTO findDentistById(Long id) throws BadRequestException;
    DentistDTO updateDentist(DentistDTO dentist) throws BadRequestException;
    List<DentistDTO> findAllDentists();
    void deleteDentistById(Long id) throws BadRequestException;
}

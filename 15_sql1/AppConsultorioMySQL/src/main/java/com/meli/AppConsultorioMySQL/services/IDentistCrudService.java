package com.meli.AppConsultorioMySQL.services;

import com.meli.AppConsultorioMySQL.dtos.DentistDto;
import com.meli.AppConsultorioMySQL.repositories.entities.DentistEntity;

import java.util.List;

public interface IDentistCrudService {
    String addOne(DentistEntity dentist);

    DentistDto getById(Long id);

    List<DentistDto> getAll();
}

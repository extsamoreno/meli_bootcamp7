package com.meli.AppConsultorioMySQL.services;

import com.meli.AppConsultorioMySQL.dtos.DentistDto;
import com.meli.AppConsultorioMySQL.repositories.IDentistRepository;
import com.meli.AppConsultorioMySQL.repositories.entities.DentistEntity;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DentistCrudService implements IDentistCrudService {

    private ModelMapper mapper;

    private IDentistRepository dentistRepository;
    @Override
    public String addOne(DentistEntity dentist) {
        dentistRepository.save(dentist);
        return "dentist added successfully";
    }

    @Override
    public DentistDto getById(Long id) {
        return mapper.map(dentistRepository.findById(id).get(), DentistDto.class);

    }

    @Override
    public List<DentistDto> getAll() {
        return dentistRepository.findAll().stream().map(d -> mapper.map(d,DentistDto.class)).collect(Collectors.toList());
    }
}

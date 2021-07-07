package com.meli.muelitas.service;

import com.meli.muelitas.dto.SpecialtyDTO;
import com.meli.muelitas.exception.SpecialtyNotExistsException;
import com.meli.muelitas.mapper.MapStructConverter;
import com.meli.muelitas.model.Specialty;
import com.meli.muelitas.repository.ISpecialtyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SpecialtyServiceImpl implements ISpecialtyService {

    @Autowired
    ISpecialtyRepository specialtyRepository;

    @Override
    public void createSpecialty(SpecialtyDTO specialtyDTO) {
        specialtyRepository.save(MapStructConverter.MAPPER.specialtyDTOtoSpecialty(specialtyDTO));
    }

    @Override
    public List<SpecialtyDTO> getSpecialtyList() {
        return MapStructConverter.MAPPER.toSpecialtyDtoList(specialtyRepository.findAll());
    }

    @Override
    public SpecialtyDTO getSpecialtyByName(String name) {
        return MapStructConverter.MAPPER.toSpecialtyDTO(specialtyRepository.findByName(name).get());
        //TODO: Add exception
    }

    @Override
    public SpecialtyDTO getSpecialtyById(Long id) {
        Specialty specialty = specialtyRepository.findById(id).orElseThrow(() -> new SpecialtyNotExistsException(id));
        return MapStructConverter.MAPPER.toSpecialtyDTO(specialty);
    }
}

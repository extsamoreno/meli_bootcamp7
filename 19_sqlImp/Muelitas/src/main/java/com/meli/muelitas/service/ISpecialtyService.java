package com.meli.muelitas.service;

import com.meli.muelitas.dto.SpecialtyDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ISpecialtyService {

    void createSpecialty(SpecialtyDTO specialtyDTO);

    List<SpecialtyDTO> getSpecialtyList();

    SpecialtyDTO getSpecialtyByName(String name);

    SpecialtyDTO getSpecialtyById(Long id);

}

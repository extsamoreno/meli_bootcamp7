package com.meli.muelitas.service;

import com.meli.muelitas.dto.DentistInDTO;
import com.meli.muelitas.dto.SpecialtyDTO;
import com.meli.muelitas.exception.DentistAlreadyExistsException;
import com.meli.muelitas.exception.DentistNotExistsException;
import com.meli.muelitas.mapper.MapStructConverter;
import com.meli.muelitas.model.Dentist;
import com.meli.muelitas.repository.IDentistRepository;
import com.meli.muelitas.dto.DentistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements IDentistService {

    @Autowired
    IDentistRepository dentistRepository;

    @Autowired
    ISpecialtyService specialtyService;

    @Override
    public void createDentist(DentistInDTO dentistInDTO) {
        if (dentistRepository.findByName(dentistInDTO.getName()).isPresent())
            throw new DentistAlreadyExistsException(dentistInDTO.getName());
        Dentist dentist = MapStructConverter.MAPPER.dentistInDTOToDentist(dentistInDTO);
        SpecialtyDTO specialtyDTO = specialtyService.getSpecialtyById(dentistInDTO.getSpecialtyId());
        dentist.setSpecialty(MapStructConverter.MAPPER.specialtyDTOtoSpecialty(specialtyDTO));
        dentist.setActive(true);
        dentistRepository.save(dentist);
    }

    @Override
    public List<DentistDTO> getDentistList() {
        return MapStructConverter.MAPPER.dentistListToDentistDTOList(dentistRepository.findAll());
    }

    @Override
    public DentistDTO getDentistById(Long id) {
        return MapStructConverter.MAPPER.dentistToDentistDTO(existsDentistByIdOrName(id, null));
    }

    @Override
    public DentistDTO getDentistByName(String name) {
        return MapStructConverter.MAPPER.dentistToDentistDTO(existsDentistByIdOrName(null, name));
    }

    private Dentist existsDentistByIdOrName(Long id, String name) {
        Optional<Dentist> dentistOptional = Optional.empty();
        if (id != null) dentistOptional = dentistRepository.findById(id);
        if (name != null) dentistOptional = dentistRepository.findByName(name);
        return dentistOptional.orElseThrow(() -> new DentistNotExistsException(id, name));
    }

}

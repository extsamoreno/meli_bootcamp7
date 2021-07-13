package com.example.dentaloffice.service;

import com.example.dentaloffice.model.dto.request.CreateDentistDTO;
import com.example.dentaloffice.model.dto.response.DentistDTO;
import com.example.dentaloffice.model.entity.Dentist;
import com.example.dentaloffice.repository.IDentistRepository;
import com.example.dentaloffice.service.mapper.IMyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService{

    // Inyected by constructor
    IDentistRepository iDentistRepository;
    IMyMapper iMyMapper;

    @Override
    public String createDentist(CreateDentistDTO dentist) {
        Dentist newDentist = new Dentist();
        newDentist.setName(dentist.getName());
        newDentist.setSurname(dentist.getSurname());
        newDentist.setDni(dentist.getDni());
        iDentistRepository.save(newDentist);
        return "Dentist created correctly";
    }

    @Override
    public List<DentistDTO> getAllDentists() {
        List<DentistDTO> dentistDTOS = iDentistRepository.findAll()
                .stream()
                .map(d -> iMyMapper.toDentistDTO(d))
                .collect(Collectors.toList());
        return dentistDTOS;
    }
}

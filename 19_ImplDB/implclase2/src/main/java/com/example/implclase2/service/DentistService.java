package com.example.implclase2.service;

import com.example.implclase2.model.dto.RequestCreateDentistDTO;
import com.example.implclase2.model.entity.Dentist;
import com.example.implclase2.repository.IDentistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService{

    IDentistRepository iDentistRepository;

    @Override
    public String createDentist(RequestCreateDentistDTO dentist) {
        Dentist newDentist = new Dentist();
        newDentist.setName(dentist.getName());
        newDentist.setSurname(dentist.getSurname());
        newDentist.setDni(dentist.getDni());
        iDentistRepository.save(newDentist);
        return "Dentist created correctly";
    }

    @Override
    public List<Dentist> getAllDentists() {
        return iDentistRepository.findAll();
    }
}

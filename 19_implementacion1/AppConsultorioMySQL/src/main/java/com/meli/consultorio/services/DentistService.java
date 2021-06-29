package com.meli.consultorio.services;

import com.meli.consultorio.models.Dentist;
import com.meli.consultorio.repositories.IDentistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService{

    IDentistRepository iDentistRepository;

    @Override
    public void createDentist(Dentist dentist) {
        iDentistRepository.save(dentist);
    }

    @Override
    public void deleteDentistById(Long id) {
        iDentistRepository.deleteById(id);
    }

    @Override
    public void updateDentist(Dentist dentist) {
        iDentistRepository.save(dentist);
    }

    @Override
    public List<Dentist> findAllDentists() {
        return iDentistRepository.findAll();
    }

    @Override
    public Dentist findDentistById(Long id) {
        Optional<Dentist> item = iDentistRepository.findById(id);
        return item.orElse(null);
    }
}

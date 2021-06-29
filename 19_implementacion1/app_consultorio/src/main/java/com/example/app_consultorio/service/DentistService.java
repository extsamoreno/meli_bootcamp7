package com.example.app_consultorio.service;

import com.example.app_consultorio.model.Dentist;
import com.example.app_consultorio.repository.IDentistRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService {

    IDentistRepository dentistRepository;

    @Override
    public void createDentist(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    @Override
    public void deleteDentistById(Long id) {
        dentistRepository.deleteById(id);
    }

    @Override
    public void updateDentist(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    @Override
    public List<Dentist> findAllDentists() {
        return dentistRepository.findAll(PageRequest.of(0, 10)).getContent();
    }

    @Override
    public Dentist findDentistById(Long id) {
        Optional<Dentist> item = dentistRepository.findById(id);
        return item.orElse(null);
    }
}

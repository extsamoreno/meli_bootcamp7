package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.models.entities.Dentist;
import com.example.AppConsultorioMySQL.repositories.IDentistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService {
    IDentistRepository dentistRepository;

    @Override
    public String createDentist(Dentist dentist) {
        dentistRepository.save(dentist);
        return "Se creó el dentista correctamente";
    }

    @Override
    public String updateDentist(Dentist dentist) {
        Optional<Dentist> item = dentistRepository.findById(dentist.getId());

        if (item == null){
            //Exception
        }

        dentistRepository.save(dentist);
        return "Se Actualizó correctamente el dentista " + dentist.getName();
    }

    @Override
    public String deleteDentist(Long id) {
        Optional<Dentist> item = dentistRepository.findById(id);

        if (item == null){
            //Exception
        }

        dentistRepository.deleteById(id);

        return "Se eliminó correctamente el dentista " + id;
    }

    @Override
    public List<Dentist> findAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist findDentistById(Long id) {
        Optional<Dentist> item = dentistRepository.findById(id);
        return item.orElse(null);
    }
}

package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.Exceptions.DentistNotFoundException;
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
    public String updateDentist(Dentist dentist) throws DentistNotFoundException {
        Optional<Dentist> item = dentistRepository.findById(dentist.getId());

        if (item == null){
            throw new DentistNotFoundException(item);
        }

        dentistRepository.save(dentist);
        return "Se Actualizó correctamente el dentista " + dentist.getName();
    }

    @Override
    public String deleteDentist(Long id) throws DentistNotFoundException {
        Optional<Dentist> item = dentistRepository.findById(id);

        if (item == null){
            throw new DentistNotFoundException(item);
        }

        dentistRepository.deleteById(id);

        return "Se eliminó correctamente el dentista " + id;
    }

    @Override
    public List<Dentist> findAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist findDentistById(Long id) throws DentistNotFoundException {
        Optional<Dentist> item = dentistRepository.findById(id);

        if (item == null){
            throw new DentistNotFoundException(item);
        }

        return item.orElse(null);
    }
}

package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.repository.IDentistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService {

    IDentistRepository iDentistRepository;

    @Override
    public void createDentist(Dentist dentist) {
        iDentistRepository.save(dentist);
    }

    @Override
    public void updateDentist(Dentist dentist) {
        iDentistRepository.save(dentist);
    }

    @Override
    public void removeDentist(int id) {
        iDentistRepository.deleteById(id);
    }

    @Override
    public List<Dentist> getDentist() {
        return iDentistRepository.findAll();
    }
}

package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.DentistDTO;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.model.Patient;
import com.appconsultorio.appconsultorio.repository.IDentistRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService {

    ModelMapper mapper;
    IDentistRepository iDentistRepository;

    @Override
    public void createDentist(DentistDTO dentistDTO) {
        Dentist dentist = mapper.map(dentistDTO, Dentist.class);
        iDentistRepository.save(dentist);
    }

    @Override
    public void updateDentist(DentistDTO dentistDTO) {
        Dentist dentist = mapper.map(dentistDTO, Dentist.class);
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

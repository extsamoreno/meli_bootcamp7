package com.meli.consultorio.services.dentist;

import com.meli.consultorio.exceptions.DentistNotFoundException;
import com.meli.consultorio.models.Dentist;
import com.meli.consultorio.models.dtos.DentistDTO;
import com.meli.consultorio.repositories.IDentistRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService{

    IDentistRepository iDentistRepository;
    ModelMapper mapper;

    @Override
    public void createDentist(DentistDTO dentist) {
        iDentistRepository.save(mapper.map(dentist,Dentist.class));
    }

    @Override
    public void deleteDentistById(Long id) {
        if(iDentistRepository.findById(id).isEmpty()) {
            throw new DentistNotFoundException(id);
        }

        iDentistRepository.deleteById(id);
    }

    @Override
    public void updateDentist(DentistDTO dentist) {
        if(iDentistRepository.findById(dentist.getId()).isEmpty()) {
            throw new DentistNotFoundException(dentist.getId());
        }

        iDentistRepository.save(mapper.map(dentist,Dentist.class));
    }

    @Override
    public Set<DentistDTO> findAllDentists() {
        List<Dentist> dentists = iDentistRepository.findAll();
        return dentists.stream().map(dentist -> mapper.map(dentist, DentistDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public DentistDTO findDentistById(Long id) {
        Dentist dentist = iDentistRepository.findById(id).orElseThrow(() -> new DentistNotFoundException(id));
        return mapper.map(dentist, DentistDTO.class);
    }
}

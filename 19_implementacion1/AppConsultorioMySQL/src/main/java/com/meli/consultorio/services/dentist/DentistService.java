package com.meli.consultorio.services.dentist;

import com.meli.consultorio.models.Dentist;
import com.meli.consultorio.models.dtos.DentistDTO;
import com.meli.consultorio.repositories.IDentistRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        iDentistRepository.deleteById(id);
    }

    @Override
    public void updateDentist(DentistDTO dentist) {
        iDentistRepository.save(mapper.map(dentist,Dentist.class));
    }

    @Override
    public List<DentistDTO> findAllDentists() {
        List<Dentist> dentists = iDentistRepository.findAll();
        return dentists.stream().map(dentist -> mapper.map(dentist, DentistDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DentistDTO findDentistById(Long id) {
        Optional<Dentist> item = iDentistRepository.findById(id);
        return item.map(dentist -> mapper.map(dentist, DentistDTO.class)).orElse(null);
    }
}

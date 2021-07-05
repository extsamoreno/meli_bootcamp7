package com.muelitas.demo.services;

import com.muelitas.demo.dtos.DentistDTO;
import com.muelitas.demo.dtos.PatientDTO;
import com.muelitas.demo.exceptions.BadRequestException;
import com.muelitas.demo.models.Dentist;
import com.muelitas.demo.models.Patient;
import com.muelitas.demo.repositories.IDentistRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService{

    private IDentistRepository dentistRepository;
    private ModelMapper mapper;

    @Override
    public void saveDentist(DentistDTO dentist) {
        Dentist dentistModel = mapper.map(dentist, Dentist.class);
        dentistRepository.save(dentistModel);
    }

    @Override
    public DentistDTO findDentistById(Long id) throws BadRequestException {
        DentistDTO dentist = validateDentist(id);
        return dentist;
    }

    @Override
    public DentistDTO updateDentist(DentistDTO dentist) throws BadRequestException {
        validateDentist(dentist.getId());
        Dentist dentistToUpdate = mapper.map(dentist, Dentist.class);
        DentistDTO dentistDTO = mapper.map(dentistRepository.save(dentistToUpdate), DentistDTO.class);
        return dentistDTO;
    }

    @Override
    public List<DentistDTO> findAllDentists() {
        List<Dentist> dentists = dentistRepository.findAll();
        return dentists.stream().map(d -> mapper.map(d, DentistDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteDentistById(Long id) throws BadRequestException {
        validateDentist(id);
        dentistRepository.deleteDentistBy(id);
    }

    private DentistDTO validateDentist(Long id) throws BadRequestException {
        if(id <= 0)
            throw new BadRequestException("El id del paciente debe ser mayor a 0");

        Optional<Dentist> dentist = dentistRepository.findPatientByDniWithoutLowDate(id);

        if(!dentist.isPresent())
            throw new BadRequestException("El dentista con el id ingresado no existe.");

        DentistDTO dentistDTO = mapper.map(dentist.get(), DentistDTO.class);

        return dentistDTO;
    }
}

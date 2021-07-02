package com.example.AppConsultorioMySQL.services;

import com.example.AppConsultorioMySQL.Exceptions.DentistNotFoundException;
import com.example.AppConsultorioMySQL.dtos.DentistDTO;
import com.example.AppConsultorioMySQL.dtos.PatientDTO;
import com.example.AppConsultorioMySQL.models.entities.Dentist;
import com.example.AppConsultorioMySQL.models.entities.Patient;
import com.example.AppConsultorioMySQL.repositories.IDentistRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService {
    IDentistRepository dentistRepository;
    ModelMapper mapper;

    @Override
    public String createDentist(DentistDTO dentistDTO) {
        dentistRepository.save(mapper.map(dentistDTO, Dentist.class));
        return "Se creó el dentista correctamente";
    }

    @Override
    public String updateDentist(DentistDTO dentistDTO) throws DentistNotFoundException {
        Optional<Dentist> item = dentistRepository.findById(dentistDTO.getId());

        if (item == null){
            throw new DentistNotFoundException(item);
        }

        dentistRepository.save(mapper.map(dentistDTO, Dentist.class));
        return "Se Actualizó correctamente el dentista " + dentistDTO.getName();
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
    public List<DentistDTO> findAllDentists() {
        List<Dentist> dentists = dentistRepository.findAll();
        return dentists.stream()
                .map(dentist -> mapper.map(dentist, DentistDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DentistDTO findDentistById(Long id) throws DentistNotFoundException {
        Optional<Dentist> item = dentistRepository.findById(id);

        if (item.isPresent()){
            throw new DentistNotFoundException(item);
        }

        return item.map(dentist -> mapper.map(dentist, DentistDTO.class)).orElse(null);
    }

    @Override
    public List<DentistDTO> listDentistMoreThan2TurnsByDate(LocalDate date) {
        List<Dentist> item = dentistRepository.listDentistMoreThan2TurnsByDate(date);
        return item.stream().map(dentist -> mapper.map(dentist,DentistDTO.class)).collect(Collectors.toList());
    }
}

package com.example.app_consultorio.service;

import com.example.app_consultorio.dto.DentistDTO;
import com.example.app_consultorio.dto.PatientDTO;
import com.example.app_consultorio.model.Dentist;
import com.example.app_consultorio.repository.IDentistRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService {

    IDentistRepository dentistRepository;
    ModelMapper mapper;

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
    public List<DentistDTO> findAllDentists() {

        List<DentistDTO> listDentistDTO = dentistRepository.findAll(PageRequest.of(0, 10)).getContent().
                stream().map(e -> mapper.map(e, DentistDTO.class)).collect(Collectors.toList());

        return listDentistDTO;
    }

    @Override
    public Dentist findDentistById(Long id) {
        Optional<Dentist> item = dentistRepository.findById(id);
        return item.orElse(null);
    }

    @Override
    public List<DentistDTO> findByAppGreaterThanTwo(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        return dentistRepository.findByAppGreaterThanTwo(localDate).stream().map(e -> mapper.map(e, DentistDTO.class)).collect(Collectors.toList());
    }

}

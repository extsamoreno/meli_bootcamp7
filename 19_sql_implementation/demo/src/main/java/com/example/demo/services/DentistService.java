package com.example.demo.services;

import com.example.demo.exceptions.DentistNotFoundException;
import com.example.demo.model.Dentist;
import com.example.demo.repositories.IAppoimentRepository;
import com.example.demo.repositories.IDentistRepository;
import com.example.demo.services.dtos.AppointmentDTO;
import com.example.demo.services.dtos.DentistDTO;
import com.example.demo.utils.Functions;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService{

    IDentistRepository iDentistRepository;

    IAppoimentRepository iAppoimentRepository;

    ModelMapper modelMapper;

    @Override
    public void createDentist(Dentist dentist) {
        iDentistRepository.save(dentist);
    }

    @Override
    public void deleteDentistById(Long id) {
        iDentistRepository.deleteById(id);
    }

    @Override
    public void updateDentist(Dentist dentist) {
        iDentistRepository.save(dentist);
    }

    @Override
    public List<Dentist> findAllDentists() {
        return iDentistRepository.findAll();
    }

    @Override
    public DentistDTO findDentistById(Long id) throws DentistNotFoundException{
        Dentist dentist = iDentistRepository.findById(id).orElseThrow(() -> new DentistNotFoundException(id));
        return modelMapper.map(dentist,DentistDTO.class);
    }

    @Override
    public List<DentistDTO> getDentistWithMoreTowAppoiments(Date date) {
        return iDentistRepository.getBusyDentists(Functions.atStartOfDay(date),Functions.atEndOfDay(date)).stream()
                .map(dentist -> modelMapper.map(dentist, DentistDTO.class) ).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getDentistDairy(Long id) throws DentistNotFoundException{
        findDentistById(id);
        List<AppointmentDTO> appointmentDTOS = iAppoimentRepository.findByDentistIdAndDateAfter(id,Functions.atStartOfDay(new Date())).stream()
                .map(appoiment -> modelMapper.map(appoiment,AppointmentDTO.class)).collect(Collectors.toList());
        return appointmentDTOS;
    }
}
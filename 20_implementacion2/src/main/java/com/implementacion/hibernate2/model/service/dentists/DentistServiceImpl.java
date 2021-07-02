package com.implementacion.hibernate2.model.service.dentists;

import com.implementacion.hibernate2.controller.dto.dentists.DentistAndTurnsDTO;
import com.implementacion.hibernate2.controller.dto.dentists.DentistAndTurnsListDTO;
import com.implementacion.hibernate2.controller.dto.dentists.DentistDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientDetailsDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientListDetailsDTO;
import com.implementacion.hibernate2.model.entity.Dentist;
import com.implementacion.hibernate2.model.repository.DentistRepository;
import com.implementacion.hibernate2.model.service.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistServiceImpl implements IDentistService{

    private final DentistRepository dentistRepository;
    private final ModelMapper mapper;

    public DentistServiceImpl(DentistRepository dentistRepository, ModelMapper mapper){
        this.dentistRepository = dentistRepository;
        this.mapper = mapper;
    }

    @Override
    public DentistDTO getDentist(Long id) {
        Dentist currentDentist = dentistRepository.getById(id);
        DentistDTO dentistDTO = mapper.map(currentDentist, DentistDTO.class);
        dentistDTO.setSchedule_id(currentDentist.getSchedule().getId());
        return dentistDTO;
    }

    @Override
    public DentistAndTurnsListDTO listDentistByDateAndTurns(String date, int turns) {
        Date actualDate = Utils.convertDate(date);
        List<Object[]> outputQuery = dentistRepository.findAllByDateAndTurns(actualDate, (long) turns);
        List<DentistAndTurnsDTO> dentistAndTurnsDTOList = outputQuery.stream()
                .map((obj) -> new DentistAndTurnsDTO((String) obj[0], (long) obj[1]))
                .collect(Collectors.toList());
        return new DentistAndTurnsListDTO(dentistAndTurnsDTOList);
    }
}

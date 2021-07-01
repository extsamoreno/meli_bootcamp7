package com.implementacion.hibernate2.model.service.dentists;

import com.implementacion.hibernate2.controller.dto.DentistDTO;
import com.implementacion.hibernate2.model.dao.Dentist;
import com.implementacion.hibernate2.model.repository.DentistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}

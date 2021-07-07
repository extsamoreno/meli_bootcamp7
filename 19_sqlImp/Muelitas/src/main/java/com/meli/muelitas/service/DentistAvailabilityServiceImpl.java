package com.meli.muelitas.service;

import com.meli.muelitas.dto.DentistAvailabilityDTO;
import com.meli.muelitas.exception.DentistAvailabilityNotExistsException;
import com.meli.muelitas.mapper.MapStructConverter;
import com.meli.muelitas.model.Dentist;
import com.meli.muelitas.model.DentistAvailability;
import com.meli.muelitas.repository.IDentistAvailabilityRepository;
import com.meli.muelitas.repository.IDentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistAvailabilityServiceImpl implements IDentistAvailabilityService {

    @Autowired
    IDentistAvailabilityRepository dentistAvailabilityRepository;

    @Autowired
    IDentistRepository dentistRepository;

    @Override
    public void addDentistAvailability(DentistAvailabilityDTO dentistAvailabilityDTO) {
        DentistAvailability dentistAvailability = MapStructConverter.MAPPER.dentistAvailabilityDTOToDentistAvailability(dentistAvailabilityDTO);
        Dentist dentist = dentistRepository.getById(dentistAvailabilityDTO.getDentistId());
        dentistAvailability.setDentist(dentist);
        dentistAvailabilityRepository.save(dentistAvailability);
    }

    @Override
    public List<DentistAvailabilityDTO> getDentistAvailabilityDTOList() {
        return MapStructConverter.MAPPER.dentistAvailabilityListToDentistAvailabilityDTOList(dentistAvailabilityRepository.findAll());
    }

    @Override
    public List<DentistAvailabilityDTO> getDentistAvailabilityByDentistId(Long dentistId) {
        return MapStructConverter.MAPPER.dentistAvailabilityListToDentistAvailabilityDTOList(dentistAvailabilityRepository.findByDentistId(dentistId));
    }

    @Override
    public List<DentistAvailabilityDTO> getDentistAvailabilityByDayOfWeekAndDentistIsActive(String dayOfWeek) {
        return MapStructConverter.MAPPER.dentistAvailabilityListToDentistAvailabilityDTOList(dentistAvailabilityRepository.findById_DayOfWeekAndDentistActive(dayOfWeek, true));
    }

    @Override
    public DentistAvailabilityDTO getAllByDayOfWeekAndDentistIsActiveAndDentistId(String dayOfWeek, Long dentistId) {
        DentistAvailability dentistAvailability = dentistAvailabilityRepository.
                findAllById_DayOfWeekAndDentistActiveAndDentistId(dayOfWeek, true, dentistId).orElseThrow(() -> new DentistAvailabilityNotExistsException(dayOfWeek, dentistId));
        return MapStructConverter.MAPPER.dentistAvailabilityToDentistAvailabilityDTO(dentistAvailability);
    }
}

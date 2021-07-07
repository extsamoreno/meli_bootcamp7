package com.meli.muelitas.service;

import com.meli.muelitas.dto.DentistAvailabilityDTO;

import java.util.List;

public interface IDentistAvailabilityService {

    void addDentistAvailability(DentistAvailabilityDTO dentistAvailabilityDTO);

    List<DentistAvailabilityDTO> getDentistAvailabilityDTOList();

    List<DentistAvailabilityDTO> getDentistAvailabilityByDentistId(Long dentistId);

    List<DentistAvailabilityDTO> getDentistAvailabilityByDayOfWeekAndDentistIsActive(String dayOfWeek);

    DentistAvailabilityDTO getAllByDayOfWeekAndDentistIsActiveAndDentistId(String dayOfWeek, Long dentistId);

}

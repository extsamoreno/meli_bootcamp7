package com.meli.Muelitas.service;

import com.meli.Muelitas.model.DTO.ProfessionalAppointmentsDTO;
import com.meli.Muelitas.model.DTO.ProfessionalDTO;

import java.text.ParseException;
import java.util.List;

public interface IProfessionalService {
    List<ProfessionalDTO> getProfessionalTwoApoointment(String date) throws ParseException;

    public List<ProfessionalAppointmentsDTO> getScheduleByDentist(Long idDentist);
}

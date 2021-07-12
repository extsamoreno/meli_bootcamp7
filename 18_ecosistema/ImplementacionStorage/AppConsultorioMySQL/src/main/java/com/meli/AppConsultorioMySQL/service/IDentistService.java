package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.DTO.DentistDTO;
import com.meli.AppConsultorioMySQL.models.DTO.DentistFullDTO;
import com.meli.AppConsultorioMySQL.models.Dentist;

import java.text.ParseException;
import java.util.List;

public interface IDentistService {
    String addDentist(Dentist dentist);
    String updateDentist(Dentist dentist);
    String deleteDentist(Long id);
    DentistFullDTO retrieveDentist(Long id);
    List<DentistDTO> getDentistTwoApoointment(String date) throws ParseException;
}

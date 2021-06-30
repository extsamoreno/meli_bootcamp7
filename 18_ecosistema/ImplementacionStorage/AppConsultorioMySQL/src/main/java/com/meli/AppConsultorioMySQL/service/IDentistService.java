package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.DTO.DentistDTO;

import java.text.ParseException;
import java.util.List;

public interface IDentistService {
    List<DentistDTO> getDentistTwoApoointment(String date) throws ParseException;
}

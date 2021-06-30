package com.meli.AppConsultorioMySQL.service;

import com.meli.AppConsultorioMySQL.models.DTO.DentistDTO;
import com.meli.AppConsultorioMySQL.models.DTO.PatientDTO;
import com.meli.AppConsultorioMySQL.models.Dentist;
import com.meli.AppConsultorioMySQL.models.Patient;
import com.meli.AppConsultorioMySQL.repositories.IDentistRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DentistService implements IDentistService{
    @Autowired
    ModelMapper mapper;

    IDentistRepository iDentistRepository;

    @Override
    public List<DentistDTO> getDentistTwoApoointment(String date) throws ParseException {

        Date date_convert = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<Dentist> dentistList = iDentistRepository.getDentistTwoApoointment(date_convert);
        System.out.println("-------->"+dentistList.toString());
        return dentistList.stream().map(dentist -> mapper.map(dentist, DentistDTO.class)).collect(Collectors.toList());

    }

}

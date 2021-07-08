package com.meli.Muelitas.service;

import com.meli.Muelitas.model.DTO.ProfessionalAppointmentsDTO;
import com.meli.Muelitas.model.DTO.ProfessionalDTO;
import com.meli.Muelitas.model.Professional;
import com.meli.Muelitas.repositories.IProfessionalRepository;
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
public class ProfessionalService implements IProfessionalService{
    @Autowired
    ModelMapper mapper;

    IProfessionalRepository iProfessionalRepository;

    @Override
    public List<ProfessionalDTO> getProfessionalTwoApoointment(String date) throws ParseException {
        Date date_convert = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<Professional> professionalList = iProfessionalRepository.getDentistTwoApoointment(date_convert);
        System.out.println("-------->"+professionalList.toString());
        return professionalList.stream().map(professional -> mapper.map(professional, ProfessionalDTO.class)).collect(Collectors.toList());

    }

    @Override
    public List<ProfessionalAppointmentsDTO> getScheduleByDentist(Long idDentist) {
        List<Professional> professionals = iProfessionalRepository.getScheduleByProfessional(idDentist);
        return professionals.stream().map(professional -> mapper.map(professional, ProfessionalAppointmentsDTO.class)).collect(Collectors.toList());

    }
}

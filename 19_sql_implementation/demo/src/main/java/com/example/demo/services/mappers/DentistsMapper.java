package com.example.demo.services.mappers;

import com.example.demo.model.Dentist;
import com.example.demo.services.dtos.DentistDTO;


public class DentistsMapper {

    public static DentistDTO toDto(Dentist dentist){

        return new DentistDTO(dentist.getId(),dentist.getName(),dentist.getScheduleSet(),dentist.getAppointments());
    }
}

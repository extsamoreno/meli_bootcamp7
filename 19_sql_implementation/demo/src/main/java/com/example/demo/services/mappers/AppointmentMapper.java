package com.example.demo.services.mappers;

import com.example.demo.model.Appointment;
import com.example.demo.services.dtos.AppointmentDTO;

public class AppointmentMapper {

    public static AppointmentDTO toDTO(Appointment appoiment){
        return new AppointmentDTO(appoiment.getId(), appoiment.getDate(), appoiment.getPatient().getName(),
                appoiment.getDentist().getName(),appoiment.getDentist().getId(), appoiment.getState().toString());
    }


}

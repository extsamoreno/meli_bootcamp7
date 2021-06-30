package com.dentists.appointments.model.mapper;

import com.dentists.appointments.model.Appointment;
import com.dentists.appointments.model.DTO.AppDTOByDate;

public class AppMapper {

    public static AppDTOByDate toAppDTOByDate(Appointment app){
        return new AppDTOByDate(app.getDentist().getName(),
                app.getPatient().getName(), app.getDate(), app.getTime(), app.getStatus());
    }
}

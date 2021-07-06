package com.appconsultorio.appconsultorio.service;

import com.appconsultorio.appconsultorio.dtos.request.CalendarsDTO;
import com.appconsultorio.appconsultorio.model.Calendars;
import com.appconsultorio.appconsultorio.model.Dentist;

import java.util.List;

public interface ICalendarService {

     void createCalendar(CalendarsDTO calendarsDTO);
     void updateCalendar(CalendarsDTO calendarsDTO);
     void removeCalendar(int id);
     List<Calendars> getCalendar() ;
}

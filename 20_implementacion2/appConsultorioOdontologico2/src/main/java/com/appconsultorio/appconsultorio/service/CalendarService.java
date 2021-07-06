package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.CalendarsDTO;
import com.appconsultorio.appconsultorio.model.Calendars;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.repository.ICalendarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CalendarService implements ICalendarService {

    ModelMapper mapper;
    ICalendarRepository iCalendarRepository;

    @Override
    public void createCalendar(CalendarsDTO calendarsDTO) {
        Calendars calendars = mapper.map(calendarsDTO, Calendars.class);
        iCalendarRepository.save(calendars);
    }

    @Override
    public void updateCalendar(CalendarsDTO calendarsDTO) {
        Calendars calendars = mapper.map(calendarsDTO, Calendars.class);
        iCalendarRepository.save(calendars);
    }

    @Override
    public void removeCalendar(int id) {
        iCalendarRepository.deleteById(id);
    }

    @Override
    public List<Calendars> getCalendar() {
        return iCalendarRepository.findAll();
    }
}

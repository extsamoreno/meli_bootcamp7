package com.appconsultorio.appconsultorio.controller;

import com.appconsultorio.appconsultorio.dtos.request.CalendarsDTO;
import com.appconsultorio.appconsultorio.model.Calendars;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.service.ICalendarService;
import com.appconsultorio.appconsultorio.service.IDentistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@RequestMapping("calendar")
@AllArgsConstructor
public class CalendarController {

    ICalendarService iCalendarService;

    @PostMapping("/create")
    public String loadCalendar(@RequestBody CalendarsDTO calendarDTO){
        iCalendarService.createCalendar(calendarDTO);
        return "Calendario creado correctamente";
    }

    @PostMapping("/edit")
    public String editDentist(@RequestBody CalendarsDTO calendarsDTO){
        iCalendarService.updateCalendar(calendarsDTO);
        return "Odontologo editado correctamente";
    }

    @PostMapping("/remove")
    public String removeDentist(@RequestParam int id){
        iCalendarService.removeCalendar(id);
        return "Odontologo eliminado correctamente";
    }

    @GetMapping("/getall")
    public List<Calendars> getCalendar(){
        return iCalendarService.getCalendar();
    }

    @GetMapping("/getcalendarfromdentist")
    public ResponseEntity<Calendars> getCalendarFromDentist(@RequestParam Integer dentist_id){
        return new ResponseEntity<>(iCalendarService.getCalendarFromDentist(dentist_id), HttpStatus.OK);
    }
}

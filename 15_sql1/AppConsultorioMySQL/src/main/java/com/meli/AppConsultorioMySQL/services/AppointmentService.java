package com.meli.AppConsultorioMySQL.services;

import com.meli.AppConsultorioMySQL.dtos.AppointmentDto;
import com.meli.AppConsultorioMySQL.repositories.IAppointmentRepository;
import com.meli.AppConsultorioMySQL.repositories.entities.AppointmentEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Calendar.DATE;

@Service
@AllArgsConstructor
public class AppointmentService implements IAppointmentCrudService{

    private ModelMapper mapper;

    private IAppointmentRepository appointmentRepository;

    @Override
    public String addOne(AppointmentEntity appointment) {
        appointmentRepository.save(appointment);
        return "schedule added successfully";
    }

    @Override
    public AppointmentDto getById(Long id) {
        return mapper.map(appointmentRepository.findById(id).get(), AppointmentDto.class);
    }

    @Override
    public List<AppointmentDto> getByDay(int day, int month, int year) {
    System.out.println("hola");

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        Date start = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, day+1);
        Date end = calendar.getTime();
        System.out.println("date.toString() = " + start.toString());
        System.out.println("date.toString() = " + end.toString());

        return appointmentRepository
                .findAllByInitBetween(start, end)
                .stream()
                .map(a-> mapper.map(a, AppointmentDto.class))
                .collect(Collectors.toList());
    }
}

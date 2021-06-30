package com.example.demo.services.Class;

import com.example.demo.model.Appointment;
import com.example.demo.repositories.IAppointmentRepository;
import com.example.demo.services.Interface.IAppointmentsService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class AppointmentsService implements IAppointmentsService {

    IAppointmentRepository iAppointmentRepository;

    @Override
    public void createAppointment(Appointment appointment){
        iAppointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment>  listAppointment() {
        return iAppointmentRepository.findAppointment();
    }

    @Override
    public List<Map<String, Object>> listDentistAppointments() {
        return iAppointmentRepository.listDentistAppointments();
    }

    @Override
    public List<Map<String, Object>>listsStatusFinish() {
        return iAppointmentRepository.listsStatusFinish();
    }


    @Override
    public List<Map<String, Object>>listsStatusPending(Date fecha) {
        DateFormat dateFormat=new SimpleDateFormat("MM.dd.yyyy HH:mm:ss");
        //Date fromDate = new Date(fecha.getYear(), fecha.getMonth(), fecha.getDate(),0,0,0);
        //"2020-03-01T00:00:00.000+00:00",
        //return iAppointmentRepository.listsStatusPending(dateFormat.format(fecha));
        return iAppointmentRepository.listsStatusPending(dateFormat.format(fecha));

    }

    @Override
    public List<Map<String, Object>> listsAgenda(Integer dentist) {
        return iAppointmentRepository.listsAgenda(dentist);
    }

    @Override
    public List<Map<String, Object>> listsresheduleDentist(Integer dentista) {
        return iAppointmentRepository.listsresheduleDentist(dentista);
    }

    @Override
    public List<Map<String, Object>> listsreshedule() {
        return iAppointmentRepository.listsreshedule();
    }


}

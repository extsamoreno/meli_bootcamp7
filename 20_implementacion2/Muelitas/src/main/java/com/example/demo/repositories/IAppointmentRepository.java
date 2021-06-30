package com.example.demo.repositories;

import com.example.demo.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {

    DateFormat dateFormat=new SimpleDateFormat("MM.dd.yyyy HH:mm:ss");

    @Query("FROM Appointment a WHERE a.date LIKE '%2020%'")
    List<Appointment> findAppointment();

    @Query("SELECT new map ( a.dentist.name as Dentista_id ) FROM Appointment a group by a.dentist having COUNT(a.dentist) > 2")
    List<Map<String, Object>> listDentistAppointments();

    @Query(" SELECT new map ( a.id,a.date,a.status,a.reschedule, a.patient.name,a.dentist.name) FROM Appointment a WHERE a.status='Finalizado'")
    List<Map<String, Object>> listsStatusFinish();

   @Query(" SELECT new map ( a.id,a.date,a.status,a.reschedule, a.patient.name,a.dentist.name) FROM Appointment a WHERE a.status='Pendiente' and a.date  >=:fecha")
    //@Query(" SELECT new map ( a.id,a.date,a.status,a.reschedule, a.patient.name,a.dentist.name) FROM Appointment a WHERE a.status='Pendiente' and a.date  >='03.01.2020'")
    List<Map<String, Object>> listsStatusPending(@Param("fecha") String fecha);


    @Query(" SELECT new map ( a.id,a.date,a.status,a.reschedule, a.patient.name,a.dentist.name) FROM Appointment a WHERE a.dentist.id  =:dentista")
    List<Map<String, Object>> listsAgenda(@Param("dentista") Integer dentista);


    @Query(" SELECT new map ( a.id,a.date,a.status,a.reschedule, a.patient.name,a.dentist.name) FROM Appointment a WHERE a.status= 'Reprogramado' and a.dentist.id  =:dentista")
    List<Map<String, Object>> listsresheduleDentist(@Param("dentista") Integer dentista);


    @Query(" SELECT new map ( a.id,a.date,a.status,a.reschedule, a.patient.name,a.dentist.name) FROM Appointment a WHERE a.status= 'Reprogramado'")
    List<Map<String, Object>> listsreshedule();



}

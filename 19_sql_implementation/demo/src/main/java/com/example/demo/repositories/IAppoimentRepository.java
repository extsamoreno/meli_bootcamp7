package com.example.demo.repositories;

import com.example.demo.model.Appointment;
import com.example.demo.model.enums.StateAppoiment;
import com.example.demo.services.dtos.AppointmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public interface IAppoimentRepository extends JpaRepository<Appointment,Long> {


    List<Appointment> findByDateBetween(Date dateStart,Date dateEnd);


    List<Appointment> findByState(StateAppoiment state);

    List<Appointment> findByDateBetweenAndState(Date atStartOfDay, Date atEndOfDay, StateAppoiment state);

    List<Appointment> findByDentistIdAndDateAfter(Long id, Date atStartOfDay);

    @Query("FROM Appointment a WHERE a.id IN (SELECT v_a.newAppointmentId FROM Appointment v_a Where v_a.state = :reschedule) " +
            " AND a.dentistId = :idDentist")
    List<Appointment> findNewRescheduleAppointmentById(StateAppoiment reschedule, Long idDentist);

    @Query("FROM Appointment a WHERE a.id IN (SELECT v_a.newAppointmentId FROM Appointment v_a Where v_a.state = :reschedule)")
    List<Appointment> findNewRescheduleAppointmentById(StateAppoiment reschedule);

    List<Appointment> findByStateAndDentistId(StateAppoiment reschedule, Long idDentist);
}

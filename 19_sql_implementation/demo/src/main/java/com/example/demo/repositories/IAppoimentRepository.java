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
}

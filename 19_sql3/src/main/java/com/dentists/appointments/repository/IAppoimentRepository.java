package com.dentists.appointments.repository;

import com.dentists.appointments.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppoimentRepository extends JpaRepository<Appointment, Long>{
}

package com.example.muelitas.repository;

import com.example.muelitas.domain.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findAppointmentsByDoctor_Id(String doctorId);
    List<Appointment> findAppointmentsByStatusEqualsCancelled();
    List<Appointment> findAppointmentsByStatusEqualsActive();

}

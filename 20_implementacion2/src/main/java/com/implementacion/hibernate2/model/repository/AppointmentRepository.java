package com.implementacion.hibernate2.model.repository;

import com.implementacion.hibernate2.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a WHERE a.status = :status")
    List<Appointment> findAllByStatus(@Param("status") String status);
}

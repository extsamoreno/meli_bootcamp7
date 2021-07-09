package com.implementacion.hibernate2.model.repository;

import com.implementacion.hibernate2.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    //@Query("SELECT a FROM Appointment a WHERE a.status = :status")
    List<Appointment> findAllByStatus(@Param("status") String status);

    //@Query(value = "SELECT * FROM appointments a WHERE a.status = 'Finalizado' AND a.date = '2021-06-02'", nativeQuery = true)
    @Query(value = "SELECT * FROM appointments a WHERE a.status = :status2 AND a.date = :date2", nativeQuery = true)
    List<Appointment> findAllByStatusAndDate(@Param("status2") String status, @Param("date2") Date date);

    //List<Appointment> findAllByStatusAndDate(String status, Date date);
}

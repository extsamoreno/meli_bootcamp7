package com.example.practica_1_integration.repositories;

import com.example.practica_1_integration.dtos.TestDTO;
import com.example.practica_1_integration.models.Appointment;
import com.example.practica_1_integration.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

public interface IConsultingRepository extends JpaRepository<Appointment, Long> {
/*
    //  Listar todos los pacientes de un día de todos los dentistas.
    @Query("SELECT Pr.name, Pr.surname, P.name, P.surname FROM Appointment A " +
            "JOIN Patient P ON A.patient.id = P.id " +
            "JOIN Professional Pr ON A.professional.id = Pr.id " +
            "WHERE DATEDIFF(A.date, :date) = 0 " +
            "ORDER BY Pr.id")
    List<Object[]> findPatientsOfProfessionalByDate(@Param("date") LocalDateTime date);
*/
    @Query("SELECT A.professional FROM Appointment A " +
            "WHERE DATEDIFF(A.date, :date) = 0")
    List<Professional> findPatientsOfProfessionalByDate(@Param("date") LocalDateTime date);

    //  Listar todos los dentistas que tengan más de dos turnos en una fecha. (en la base no hay ninguno)
    @Query( "SELECT Pr.name, Pr.surname " +
            "FROM Professional Pr " +
            "JOIN Appointment A ON A.professional.id = Pr.id " +
            "WHERE DATEDIFF(A.date, :date) = 0 " +
            "GROUP BY Pr.id HAVING COUNT(Pr.id) > 2")
    List<Object[]> findProfessionalsByDateAndMoreThanTwoAppointments(@Param("date") LocalDateTime date);

}

package com.meli.Muelitas.repositories;


import com.meli.Muelitas.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("FROM Appointment a where a.status = 2 ")
    List<Appointment> getAppointmentFinish();

    @Query("FROM Appointment a where " +
            " a.status = 1 and  YEAR(a.date)=YEAR(:date) and MONTH(a.date)=MONTH(:date) and DAY(a.date)=DAY(:date) ")
    List<Appointment>getAppointmentPendingByDate(Date date);

    @Query("select a FROM Appointment a join Professional p on a.professional.id=p.id where" +
            " a.status = 3 and p.id=:idProfessional ")
    List<Appointment> getAppointmentsReprogrammedByProf(Long idProfessional);

    @Query("FROM Appointment a where a.status = 3")
    List<Appointment> getAppointmentsReprogrammed();

}

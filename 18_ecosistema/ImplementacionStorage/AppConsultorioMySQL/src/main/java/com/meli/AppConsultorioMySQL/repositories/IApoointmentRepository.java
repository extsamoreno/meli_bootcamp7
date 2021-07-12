package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.Apoointment;
import com.meli.AppConsultorioMySQL.models.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public interface IApoointmentRepository extends JpaRepository<Apoointment, Long> {

    @Query("FROM Apoointment a where" +
            " a.status = 2 ")
    List<Apoointment> getAppointmentFinish();


    @Query("FROM Apoointment a where " +
            " a.status = 1 and  YEAR(a.date)=YEAR(:date) and MONTH(a.date)=MONTH(:date) and DAY(a.date)=DAY(:date) ")
    List<Apoointment>getAppointmentPendingByDate(Date date);

    @Query("select a FROM Apoointment a join Schedule s on  a.schedule.id=s.id join Dentist d on s.dentist.id=d.id where" +
            " a.status = 3 and d.id=:idDentist ")
    List<Apoointment> getAppointmentsReprogrammed(Long idDentist);

    @Query("FROM Apoointment a where" +
            " a.status = 3")
    List<Apoointment> getAppointmentsReprogrammedAllDentist();

    @Query(value= "select a from Apoointment a where a.schedule.id=:id")
    Collection<Apoointment> getAppointmentBySchedule(Long id);

}

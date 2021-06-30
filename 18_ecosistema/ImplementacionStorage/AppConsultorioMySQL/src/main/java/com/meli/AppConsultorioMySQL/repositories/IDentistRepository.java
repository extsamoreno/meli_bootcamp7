package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.Dentist;
import com.meli.AppConsultorioMySQL.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {

    @Query("select d FROM Dentist d join Schedule s on d.id=s.dentist.id join Apoointment a on a.schedule.id=s.id  where" +
            " YEAR(a.date)=YEAR(:date) and MONTH(a.date)=MONTH(:date) and DAY(a.date)=DAY(:date) GROUP BY d HAVING COUNT(d.id)>2 ")
    List<Dentist> getDentistTwoApoointment(Date date);

}

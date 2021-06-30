package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.Patient;
import com.meli.AppConsultorioMySQL.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("select s FROM Schedule s join Dentist d on s.dentist.id=d.id join  Apoointment a on a.schedule.id=s.id where d.id=:idDentist")
    List<Schedule> getScheduleByDentist(Long idDentist);

}

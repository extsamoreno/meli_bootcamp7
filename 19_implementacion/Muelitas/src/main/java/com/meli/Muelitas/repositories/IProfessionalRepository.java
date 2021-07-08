package com.meli.Muelitas.repositories;


import com.meli.Muelitas.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IProfessionalRepository extends JpaRepository<Professional, Long> {

    @Query("select p FROM Professional p join Appointment a on a.professional.id = p.id  where" +
            " YEAR(a.date)=YEAR(:date) and MONTH(a.date)=MONTH(:date) and DAY(a.date)=DAY(:date) GROUP BY p HAVING COUNT(p.id)>2 ")
    List<Professional> getDentistTwoApoointment(Date date);

    @Query("FROM Professional p where p.id=:idProfessional")
    List<Professional> getScheduleByProfessional(Long idProfessional);
}

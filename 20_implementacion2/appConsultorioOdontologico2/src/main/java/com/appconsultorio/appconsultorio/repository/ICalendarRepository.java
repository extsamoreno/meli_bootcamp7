package com.appconsultorio.appconsultorio.repository;
import com.appconsultorio.appconsultorio.model.Calendars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICalendarRepository extends JpaRepository<Calendars,Integer> {

    @Query("select c from Calendars c " +
            "where c.dentist.id = :dentist_id ")
    Calendars getCalendarFromDentist(Integer dentist_id);

}

package com.dentists.appointments.repository;

import com.dentists.appointments.model.Appointment;
import com.dentists.appointments.model.DTO.DentistCountDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAppoimentRepository extends JpaRepository<Appointment, Long>{

    List<Appointment> findAppointmentBydate(LocalDate localDate);

    @Query(value = "select de.name as name, app.date as date, count(de.id) as numberDates " +
            "from Appointment app " +
            "inner join Dentist de  ON de.id = app.dentist.id " +
            "WHERE app.date = :date " +
            "group by de.name having count(de.id) > 2")
    List<DentistCountDates> findDentistWithMoreThat2App(@Param("date")LocalDate date);


}

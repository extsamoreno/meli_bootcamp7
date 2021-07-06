package com.appconsultorio.appconsultorio.repository;
import com.appconsultorio.appconsultorio.model.Calendars;
import com.appconsultorio.appconsultorio.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICalendarRepository extends JpaRepository<Calendars,Integer> {
}

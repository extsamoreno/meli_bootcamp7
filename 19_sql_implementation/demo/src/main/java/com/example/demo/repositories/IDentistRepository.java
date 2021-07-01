package com.example.demo.repositories;

import com.example.demo.model.Dentist;
import com.example.demo.services.dtos.DentistDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {

    @Query("FROM Dentist d " +
            "WHERE d.id IN " +
            "(SELECT a.dentist.id FROM Appointment  a WHERE  a.date BETWEEN :atStartOfDay AND :atEndOfDay " +
            " GROUP BY a.dentist.id HAVING count (a.dentist.id) >= 2) ")
    List<Dentist> getBusyDentists(Date atStartOfDay, Date atEndOfDay);
}

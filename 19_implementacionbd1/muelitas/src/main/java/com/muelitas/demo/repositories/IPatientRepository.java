package com.muelitas.demo.repositories;

import com.muelitas.demo.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
    @Transactional
    @Modifying
    @Query("update Patient d set d.lowDate = current_time where d.id =:id")
    void deletePatientBy(@Param("id") Long id);

    @Query("from Patient p where p.id = :id and p.lowDate is null")
    Optional<Patient> findPatientByIdWithoutLowDate(@Param("id") Long id);

    @Query("from Patient p where p.lowDate is null")
    List<Patient> findAll();
}

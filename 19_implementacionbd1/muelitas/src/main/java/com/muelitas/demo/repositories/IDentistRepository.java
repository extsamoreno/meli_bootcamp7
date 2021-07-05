package com.muelitas.demo.repositories;

import com.muelitas.demo.models.Dentist;
import com.muelitas.demo.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {
    @Transactional
    @Modifying
    @Query("update Dentist d set d.lowDate = current_time where d.id =:id")
    void deleteDentistBy(@Param("id") Long id);

    @Query("from Dentist d where d.id = :id and d.lowDate is null")
    Optional<Dentist> findPatientByIdWithoutLowDate(@Param("id") Long id);

    @Query("from Dentist d where d.lowDate is null")
    List<Dentist> findAll();
}

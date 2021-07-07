package com.meli.muelitas.repository;

import com.meli.muelitas.model.DentistAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDentistAvailabilityRepository extends JpaRepository<DentistAvailability, Long> {

    List<DentistAvailability> findByDentistId(Long dentist_id);

    List<DentistAvailability> findById_DayOfWeekAndDentistActive(String dayOfWeek, boolean active);

    Optional<DentistAvailability> findAllById_DayOfWeekAndDentistActiveAndDentistId(String dayOfWeek, boolean active, Long dentistId);

}

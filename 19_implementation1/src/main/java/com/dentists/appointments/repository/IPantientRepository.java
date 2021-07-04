package com.dentists.appointments.repository;

import com.dentists.appointments.model.Dentist;
import com.dentists.appointments.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPantientRepository extends JpaRepository<Patient, Long>{

    Patient findFirstByName(String name);

    Patient findFirstByDni(String dni);
}

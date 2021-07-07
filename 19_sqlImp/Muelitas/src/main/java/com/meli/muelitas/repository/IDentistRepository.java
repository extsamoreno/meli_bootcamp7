package com.meli.muelitas.repository;

import com.meli.muelitas.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDentistRepository extends JpaRepository<Dentist, Long> {

    Optional<Dentist> findByName(String name);

}

package com.example.practica_1_integration.repositories;

import com.example.practica_1_integration.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfessionalRepository extends JpaRepository<Professional, Long> {
}

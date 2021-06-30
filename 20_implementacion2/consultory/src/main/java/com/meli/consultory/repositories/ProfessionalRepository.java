package com.meli.consultory.repositories;

import com.meli.consultory.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
}

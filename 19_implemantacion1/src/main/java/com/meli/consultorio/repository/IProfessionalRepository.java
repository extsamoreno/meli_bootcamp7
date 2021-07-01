package com.meli.consultorio.repository;

import com.meli.consultorio.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfessionalRepository extends JpaRepository<Professional,Integer> {

}

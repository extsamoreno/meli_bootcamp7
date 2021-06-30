package com.consultorio.AppConsultorioMySQL.repository;

import com.consultorio.AppConsultorioMySQL.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist,Long> {
}

package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.DentistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDentistRepository extends JpaRepository<DentistEntity, Long> {
}

package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.DentistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<DentistEntity, Long> {
}

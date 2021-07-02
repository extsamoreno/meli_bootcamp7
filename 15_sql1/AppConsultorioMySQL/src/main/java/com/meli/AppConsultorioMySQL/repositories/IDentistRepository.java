package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.repositories.entities.DentistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<DentistEntity, Long> {

}

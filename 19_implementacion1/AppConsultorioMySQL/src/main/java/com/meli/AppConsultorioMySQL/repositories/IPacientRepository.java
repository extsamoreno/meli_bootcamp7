package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.PacientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacientRepository extends JpaRepository<PacientEntity,Long> {

}

package com.example.appConsultorioMySQL.repository;

import com.example.appConsultorioMySQL.models.DAO.TurnoDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface iTurnoRepo extends CrudRepository<TurnoDAO, LocalDate> {
}

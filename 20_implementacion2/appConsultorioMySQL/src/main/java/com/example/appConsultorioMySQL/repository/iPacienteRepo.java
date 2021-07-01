package com.example.appConsultorioMySQL.repository;

import com.example.appConsultorioMySQL.models.DAO.PacienteDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iPacienteRepo extends CrudRepository<PacienteDAO, Long> {
}

package com.example.appConsultorioMySQL.repository;

import com.example.appConsultorioMySQL.models.DAO.AgendaDAO;
import com.example.appConsultorioMySQL.models.DAO.OdontologoDAO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iOdontologoRepo extends CrudRepository<OdontologoDAO, Long> {

}

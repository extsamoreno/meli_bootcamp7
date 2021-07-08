package com.appconsultorio.appconsultorio.repository;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ITurnRepository extends JpaRepository<Turn,Integer> {

    //listar todos los turnos finalizados
    @Query("SELECT t FROM Turn t where t.status LIKE '%Finalizado%' ")
    List<Turn> findTurnosLikeFinalizado();

}
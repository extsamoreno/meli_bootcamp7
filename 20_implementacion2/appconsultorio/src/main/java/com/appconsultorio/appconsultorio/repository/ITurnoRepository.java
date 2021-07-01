package com.appconsultorio.appconsultorio.repository;
import com.appconsultorio.appconsultorio.model.Odontologo;
import com.appconsultorio.appconsultorio.model.Paciente;
import com.appconsultorio.appconsultorio.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno,Integer> {

    @Query("SELECT t.paciente, t.odontologo FROM Turno t WHERE t.fecha = :dt")
    List findPacientesByDate(@Param("dt") LocalDateTime dt);

    @Query("SELECT t.odontologo FROM Turno t where t.fecha = :dt group by t.odontologo having count(t.odontologo) >= 2")
    List<Odontologo> findOdontologosDosTurnosPorFecha(@Param("dt") LocalDateTime dt);

    @Query("SELECT t FROM Turno t where t.estado LIKE '%Finalizado%' ")
    List<Turno> findTurnosLikeFinalizado();


}

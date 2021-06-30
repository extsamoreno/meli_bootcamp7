package com.appconsultorio.appconsultorio.repository;
import com.appconsultorio.appconsultorio.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno,Integer> {

}

package com.example.implclase2.repository;

import com.example.implclase2.model.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {
    //@Query
    List<Turn> findTurnByPatientDni(@Param("dni") String dni);
}

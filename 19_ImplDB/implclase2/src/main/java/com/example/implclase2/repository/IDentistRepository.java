package com.example.implclase2.repository;

import com.example.implclase2.model.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {
    //@Query("select d from dentists d where d.dentist_dni = :dni")
    Dentist findDentistByDni(@Param("dni") String dni);
}

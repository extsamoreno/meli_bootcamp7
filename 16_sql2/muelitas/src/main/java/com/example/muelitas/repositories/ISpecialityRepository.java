package com.example.muelitas.repositories;

import com.example.muelitas.models.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISpecialityRepository extends JpaRepository<Especialidad,Long> {

}

package com.example.muelitas.repositories;

import com.example.muelitas.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Paciente,Long> {
}

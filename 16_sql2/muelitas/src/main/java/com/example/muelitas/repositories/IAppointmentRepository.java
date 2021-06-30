package com.example.muelitas.repositories;

import com.example.muelitas.models.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends JpaRepository<Turno,Long> {
}

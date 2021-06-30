package com.meli.consultorio.repository;

import com.meli.consultorio.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicioRepository extends JpaRepository<Servicio, Integer> {
}

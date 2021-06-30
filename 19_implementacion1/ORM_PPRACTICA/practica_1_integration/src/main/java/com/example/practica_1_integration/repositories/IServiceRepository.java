package com.example.practica_1_integration.repositories;

import com.example.practica_1_integration.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service, Long> {
}

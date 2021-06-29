package com.example.AppConsultorioMySQL.repositories;

import com.example.AppConsultorioMySQL.models.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnRepository extends JpaRepository<Turn, Long> {
}

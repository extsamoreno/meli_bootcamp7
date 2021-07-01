package com.meli.consultorio.repository;

import com.meli.consultorio.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnRepository extends JpaRepository<Turn,Integer> {
}

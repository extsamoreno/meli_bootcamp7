package com.example.demo.repositories;

import com.example.demo.model.Boss;
import com.example.demo.model.Consultory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBossesRepository extends JpaRepository<Boss, Integer> {
}

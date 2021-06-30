package com.example.demo.repositories;

import com.example.demo.model.Patient;
import com.example.demo.model.Shedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISheduleRepository extends JpaRepository<Shedule, Integer> {

}

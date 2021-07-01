package com.implementacion.hibernate2.model.repository;

import com.implementacion.hibernate2.model.dao.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {

}

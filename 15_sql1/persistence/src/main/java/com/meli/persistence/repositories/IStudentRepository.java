package com.meli.persistence.repositories;

import com.meli.persistence.repositories.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity, Long> {

}

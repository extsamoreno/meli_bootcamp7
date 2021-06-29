package com.example.muelitas.repositories;

import com.example.muelitas.models.Profesional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfessionalRepository extends JpaRepository<Profesional,Long> {
    @Override @EntityGraph(attributePaths = {"especialidad"})
    public Optional<Profesional> findById(Long id);
}

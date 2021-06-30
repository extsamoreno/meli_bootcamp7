package com.appconsultorio.appconsultorio.repository;
import com.appconsultorio.appconsultorio.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Integer> {
}

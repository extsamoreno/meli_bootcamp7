package com.appconsultorio.appconsultorio.repository;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {
}

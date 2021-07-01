package sql.imple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sql.imple.models.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
}

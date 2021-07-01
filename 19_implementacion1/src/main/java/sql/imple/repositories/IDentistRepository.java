package sql.imple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sql.imple.models.Dentist;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {
}

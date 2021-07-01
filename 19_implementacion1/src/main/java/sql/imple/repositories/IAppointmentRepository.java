package sql.imple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sql.imple.models.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

}

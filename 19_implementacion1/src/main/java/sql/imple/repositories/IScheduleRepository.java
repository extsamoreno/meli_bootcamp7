package sql.imple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sql.imple.models.Schedule;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Long> {
}

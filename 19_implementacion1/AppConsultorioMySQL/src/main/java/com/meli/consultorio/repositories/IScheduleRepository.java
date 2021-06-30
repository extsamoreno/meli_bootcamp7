package com.meli.consultorio.repositories;

import com.meli.consultorio.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Long> {
}

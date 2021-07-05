package com.meli.consultorio.repository;

import com.meli.consultorio.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScheduleRepository extends JpaRepository<Schedule,Integer> {

}

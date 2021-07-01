package com.example.mongodbexample.repository;

import com.example.mongodbexample.domain.Schedule;

import com.example.mongodbexample.dto.ScheduleDoctorDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {

    @Query(value = "{'doctor.lastName':'?0'}", fields = "{'doctor': 0}")
    List<Schedule> findSchedulesByDoctor (String lastName);

    @Query(value = "{'status':'?0'}")
    List<Schedule> findSchedulesByStatus(String status);
}

package com.example.mongodbexample.repository;

import com.example.mongodbexample.domain.Schedule;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {

    List<Schedule> findSchedulesByDoctor(String doctor);
}
